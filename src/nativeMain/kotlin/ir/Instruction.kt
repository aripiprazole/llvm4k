/*
 *    Copyright 2022 Plank
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.plank.llvm4k.ir

import kotlinx.cinterop.cValuesOf
import kotlinx.cinterop.toCValues
import llvm.LLVMValueRef

public actual sealed class Instruction : Value()

public actual class CallInst(public override val ref: LLVMValueRef?) : Instruction()

public actual class ReturnInst(public override val ref: LLVMValueRef?) : Instruction()

public actual class BranchInst(public override val ref: LLVMValueRef?) : Instruction() {
  public actual val isConditional: Boolean get() = llvm.LLVMIsConditional(ref) == 1

  public actual var condition: Value?
    get(): Value? = when (isConditional) {
      true -> Value(llvm.LLVMGetCondition(ref))
      false -> null
    }
    set(value) {
      if (!isConditional) return
      if (value == null) return

      llvm.LLVMSetCondition(ref, value.ref)
    }
}

public actual class SwitchInst(public override val ref: LLVMValueRef?) : Instruction()

public actual class IndirectBrInst(public override val ref: LLVMValueRef?) : Instruction()

public actual class InvokeInst(public override val ref: LLVMValueRef?) : Instruction()

public actual class ResumeInst(public override val ref: LLVMValueRef?) : Instruction()

public actual class CleanupReturnInst(public override val ref: LLVMValueRef?) : Instruction()

public actual class CatchSwitchInst(public override val ref: LLVMValueRef?) : Instruction()

public actual class CatchPadInst(public override val ref: LLVMValueRef?) : Instruction()

public actual class CleanupPadInst(public override val ref: LLVMValueRef?) : Instruction()

public actual class CatchReturnInst(public override val ref: LLVMValueRef?) : Instruction()

public actual class UnreachableInst(public override val ref: LLVMValueRef?) : Instruction()

public actual class AllocaInst(public override val ref: LLVMValueRef?) : Instruction()

public actual class LoadInst(public override val ref: LLVMValueRef?) : Instruction()

public actual class StoreInst(public override val ref: LLVMValueRef?) : Instruction()

public actual class FenceInst(public override val ref: LLVMValueRef?) : Instruction()

public actual class AtomicCmpXchgInst(public override val ref: LLVMValueRef?) : Instruction()

public actual class AtomicRMWInst(public override val ref: LLVMValueRef?) : Instruction()

public actual class LandingPadInst(public override val ref: LLVMValueRef?) : Instruction()

private class InstructionImpl(override val ref: LLVMValueRef?) : Instruction()

public actual class PhiInst(public override val ref: LLVMValueRef?) : Instruction() {
  public actual fun addIncoming(value: Value, block: BasicBlock) {
    llvm.LLVMAddIncoming(ref, cValuesOf(value.ref), cValuesOf(block.ref), 1u)
  }

  public actual fun addIncoming(vararg incoming: Pair<Value, BasicBlock>) {
    llvm.LLVMAddIncoming(
      ref,
      incoming.map { it.first.ref }.toCValues(),
      incoming.map { it.second.ref }.toCValues(),
      incoming.size.toUInt(),
    )
  }
}

@Suppress("ComplexMethod", "LongMethod")
public fun Instruction(ref: LLVMValueRef?): Instruction {
  return when (Opcode.byValue(llvm.LLVMGetInstructionOpcode(ref).value)) {
    Opcode.Ret -> ReturnInst(ref)
    Opcode.Br -> BranchInst(ref)
    Opcode.Switch -> SwitchInst(ref)
    Opcode.IndirectBr -> IndirectBrInst(ref)
    Opcode.Invoke -> InvokeInst(ref)
    Opcode.Unreachable -> UnreachableInst(ref)
    Opcode.Alloca -> AllocaInst(ref)
    Opcode.Load -> LoadInst(ref)
    Opcode.Store -> StoreInst(ref)
    Opcode.Call -> CallInst(ref)
    Opcode.Fence -> FenceInst(ref)
    Opcode.AtomicCmpXchg -> AtomicCmpXchgInst(ref)
    Opcode.AtomicRMW -> AtomicRMWInst(ref)
    Opcode.Resume -> ResumeInst(ref)
    Opcode.LandingPad -> LandingPadInst(ref)
    Opcode.CatchRet -> CatchReturnInst(ref)
    Opcode.CatchPad -> CatchPadInst(ref)
    Opcode.CleanupPad -> CleanupPadInst(ref)
    Opcode.CatchSwitch -> CatchSwitchInst(ref)
    Opcode.PHI -> PhiInst(ref)
    else -> InstructionImpl(ref)
  }
}
