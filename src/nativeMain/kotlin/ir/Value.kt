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

import kotlinx.cinterop.toKString
import llvm.LLVMValueKind
import llvm.LLVMValueRef
import org.plank.llvm4k.Owner
import org.plank.llvm4k.printToString

public actual sealed interface Value : Owner<LLVMValueRef> {
  public actual val type: Type get() = Type(llvm.LLVMTypeOf(ref))
  public actual val kind: Kind get() = Kind.byValue(llvm.LLVMGetValueKind(ref).value)

  public actual val isConstant: Boolean get() = llvm.LLVMIsConstant(ref) == 1
  public actual val isUndef: Boolean get() = llvm.LLVMIsUndef(ref) == 1
  public actual val asBasicBlock: BasicBlock get() = BasicBlock(llvm.LLVMValueAsBasicBlock(ref))

  public actual fun replace(other: Value) {
    llvm.LLVMReplaceAllUsesWith(ref, other.ref)
  }

  public actual override fun toString(): String

  public actual enum class Kind(public val llvm: LLVMValueKind) {
    Argument(LLVMValueKind.LLVMArgumentValueKind),
    BasicBlock(LLVMValueKind.LLVMBasicBlockValueKind),
    MemoryUse(LLVMValueKind.LLVMMemoryUseValueKind),
    MemoryDef(LLVMValueKind.LLVMMemoryDefValueKind),
    MemoryPhi(LLVMValueKind.LLVMMemoryPhiValueKind),
    Function(LLVMValueKind.LLVMFunctionValueKind),
    GlobalAlias(LLVMValueKind.LLVMGlobalAliasValueKind),
    GlobalIFunc(LLVMValueKind.LLVMGlobalIFuncValueKind),
    GlobalVariable(LLVMValueKind.LLVMGlobalVariableValueKind),
    BlockAddress(LLVMValueKind.LLVMBlockAddressValueKind),
    ConstantExpr(LLVMValueKind.LLVMConstantExprValueKind),
    ConstantArray(LLVMValueKind.LLVMConstantArrayValueKind),
    ConstantStruct(LLVMValueKind.LLVMConstantStructValueKind),
    ConstantVector(LLVMValueKind.LLVMConstantVectorValueKind),
    UndefValue(LLVMValueKind.LLVMUndefValueValueKind),
    ConstantAggregateZero(LLVMValueKind.LLVMConstantAggregateZeroValueKind),
    ConstantDataArray(LLVMValueKind.LLVMConstantDataArrayValueKind),
    ConstantDataVector(LLVMValueKind.LLVMConstantDataVectorValueKind),
    ConstantInt(LLVMValueKind.LLVMConstantIntValueKind),
    ConstantFP(LLVMValueKind.LLVMConstantFPValueKind),
    ConstantPointerNull(LLVMValueKind.LLVMConstantPointerNullValueKind),
    ConstantTokenNone(LLVMValueKind.LLVMConstantTokenNoneValueKind),
    MetadataAsValue(LLVMValueKind.LLVMMetadataAsValueValueKind),
    InlineAsm(LLVMValueKind.LLVMInlineAsmValueKind),
    Instruction(LLVMValueKind.LLVMInstructionValueKind),
    PoisonValue(LLVMValueKind.LLVMPoisonValueValueKind);

    public actual val value: UInt get() = llvm.value

    public actual companion object {
      public fun byValue(llvm: LLVMValueKind): Kind {
        return byValue(llvm.value)
      }

      public actual fun byValue(value: Int): Kind {
        return byValue(value.toUInt())
      }

      public actual fun byValue(value: UInt): Kind {
        return values().single { it.value == value }
      }
    }
  }
}

public actual sealed interface NamedValue : Value {
  public actual var name: String
    get(): String = llvm.LLVMGetValueName(ref)!!.toKString()
    set(value) {
      llvm.LLVMSetValueName(ref, value)
    }
}

internal class ValueImpl(override val ref: LLVMValueRef?) : Value {
  override fun toString(): String = printToString()
}

internal class NamedValueImpl(override val ref: LLVMValueRef?) : NamedValue {
  override fun toString(): String = printToString()
}

@Suppress("ComplexMethod")
public fun Value(ref: LLVMValueRef?): Value {
  return when (Value.Kind.byValue(llvm.LLVMGetValueKind(ref).value)) {
    Value.Kind.Argument -> Argument(ref)
    Value.Kind.BasicBlock -> BasicBlock.AsValue(ref)
    Value.Kind.MemoryUse -> MemoryUse(ref)
    Value.Kind.MemoryDef -> MemoryDef(ref)
    Value.Kind.MemoryPhi -> MemoryPhi(ref)
    Value.Kind.Function -> Function(ref)
    Value.Kind.GlobalAlias -> GlobalAlias(ref)
    Value.Kind.GlobalIFunc -> GlobalIFunc(ref)
    Value.Kind.GlobalVariable -> GlobalVariable(ref)
    Value.Kind.BlockAddress -> BlockAddress(ref)
    Value.Kind.ConstantExpr -> ConstantExpr(ref)
    Value.Kind.ConstantArray -> ConstantDataArray(ref)
    Value.Kind.ConstantStruct -> ConstantAggregate(ref)
    Value.Kind.ConstantVector -> ConstantDataVector(ref)
    Value.Kind.UndefValue -> UndefValue(ref)
    Value.Kind.ConstantAggregateZero -> ConstantAggregate(ref)
    Value.Kind.ConstantDataArray -> ConstantDataArray(ref)
    Value.Kind.ConstantDataVector -> ConstantDataVector(ref)
    Value.Kind.ConstantInt -> ConstantInt(ref)
    Value.Kind.ConstantFP -> ConstantFP(ref)
    Value.Kind.ConstantPointerNull -> ConstantPointerNull(ref)
    Value.Kind.ConstantTokenNone -> ConstantTokenNone(ref)
    Value.Kind.MetadataAsValue -> MetadataAsValue(ref)
    Value.Kind.InlineAsm -> InlineAsm(ref)
    Value.Kind.Instruction -> Instruction(ref)
    Value.Kind.PoisonValue -> PoisonValue(ref)
  }
}
