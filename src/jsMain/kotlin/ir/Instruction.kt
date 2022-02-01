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

public actual sealed class Instruction : Value()

public actual class CallInst : Instruction()

public actual class ReturnInst : Instruction()

public actual class BranchInst : Instruction() {
  public actual val isConditional: Boolean
    get() = TODO("Not yet implemented")

  public actual var condition: Value?
    get() = TODO("Not yet implemented")
    set(value) {}
}

public actual class SwitchInst : Instruction()

public actual class IndirectBrInst : Instruction()

public actual class InvokeInst : Instruction()

public actual class ResumeInst : Instruction()

public actual class CleanupReturnInst : Instruction()

public actual class CatchSwitchInst : Instruction()

public actual class CatchPadInst : Instruction()

public actual class CleanupPadInst : Instruction()

public actual class CatchReturnInst : Instruction()

public actual class UnreachableInst : Instruction()

public actual class AllocaInst : Instruction()

public actual class LoadInst : Instruction()

public actual class StoreInst : Instruction()

public actual class FenceInst : Instruction()

public actual class AtomicCmpXchgInst : Instruction()

public actual class AtomicRMWInst : Instruction()

public actual class LandingPadInst : Instruction()

public actual class PhiInst : Instruction() {
  public actual fun addIncoming(value: Value, block: BasicBlock) {
  }

  public actual fun addIncoming(vararg incoming: Pair<Value, BasicBlock>) {
  }
}
