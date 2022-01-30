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

public actual sealed class Value {
  public actual open val type: Type
    get() = TODO("Not yet implemented")

  public actual open val kind: Kind
    get() = TODO("Not yet implemented")

  public actual open val isConstant: Boolean
    get() = TODO("Not yet implemented")

  public actual open val isUndef: Boolean
    get() = TODO("Not yet implemented")

  public actual open val asBasicBlock: BasicBlock
    get() = TODO("Not yet implemented")

  public actual open fun replace(other: Value) {
  }

  public actual override fun toString(): String {
    TODO("Not yet implemented")
  }

  public actual enum class Kind {
    Argument,
    BasicBlock,
    MemoryUse,
    MemoryDef,
    MemoryPhi,
    Function,
    GlobalAlias,
    GlobalIFunc,
    GlobalVariable,
    BlockAddress,
    ConstantExpr,
    ConstantArray,
    ConstantStruct,
    ConstantVector,
    UndefValue,
    ConstantAggregateZero,
    ConstantDataArray,
    ConstantDataVector,
    ConstantInt,
    ConstantFP,
    ConstantPointerNull,
    ConstantTokenNone,
    MetadataAsValue,
    InlineAsm,
    Instruction,
    PoisonValue;

    public actual val value: UInt
      get() = TODO("Not yet implemented")

    public actual companion object {
      public actual fun byValue(value: Int): Kind {
        TODO("Not yet implemented")
      }

      public actual fun byValue(value: UInt): Kind {
        TODO("Not yet implemented")
      }
    }
  }
}

public actual interface NamedValue {
  public actual var name: String
    get() = TODO("Not yet implemented")
    set(value) {}
}
