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

import org.plank.llvm4k.Context

public actual sealed class Type {
  public actual open val context: Context
    get() = TODO("Not yet implemented")

  public actual open val isSized: Boolean
    get() = TODO("Not yet implemented")

  public actual open val size: ConstantInt
    get() = TODO("Not yet implemented")

  public actual open val align: ConstantInt
    get() = TODO("Not yet implemented")

  public actual open val kind: Kind
    get() = TODO("Not yet implemented")

  public actual open fun pointer(addrSpace: AddrSpace): PointerType {
    TODO("Not yet implemented")
  }

  public actual enum class Kind {
    Void,
    Half,
    Float,
    Double,
    X86_FP80,
    FP128,
    PPC_FP128,
    Label,
    Integer,
    Function,
    Struct,
    Array,
    Pointer,
    Vector,
    Metadata,
    X86_MMX,
    Token,
    ScalableVector,
    BFloat,
    X86_AMX;

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

public actual class StructType : Type() {
  public actual val name: String?
    get() = TODO("Not yet implemented")

  public actual val isPacked: Boolean
    get() = TODO("Not yet implemented")

  public actual val isOpaque: Boolean
    get() = TODO("Not yet implemented")

  public actual val isLiteral: Boolean
    get() = TODO("Not yet implemented")

  public actual val hasName: Boolean
    get() = TODO("Not yet implemented")

  public actual var elements: List<Type>
    get() = TODO("Not yet implemented")
    set(value) {}

  public actual val constantNull: ConstantAggregate
    get() = TODO("Not yet implemented")

  public actual fun getConstant(vararg elements: Constant, isPacked: Boolean): ConstantAggregate {
    TODO("Not yet implemented")
  }
}

public actual sealed class CompositeType : Type() {
  public actual abstract val count: Int

  public actual val elements: List<Type>
    get() = TODO("Not yet implemented")

  public actual val contained: Type
    get() = TODO("Not yet implemented")
}

public actual sealed class VectorType : CompositeType() {
  public actual val constantNull: ConstantDataVector
    get() = TODO("Not yet implemented")
}

public actual class FixedVectorType public actual constructor(
  contained: Type,
  count: Int
) : VectorType() {
  public override val count: Int
    get() = TODO("Not yet implemented")
}

public actual class ScalableVectorType public actual constructor(
  contained: Type,
  minCount: Int
) : VectorType() {
  public override val count: Int
    get() = TODO("Not yet implemented")
}

public actual class ArrayType public actual constructor(
  contained: Type,
  count: Int
) : CompositeType() {
  public actual val constantNull: ConstantDataArray
    get() = TODO("Not yet implemented")

  public override val count: Int
    get() = TODO("Not yet implemented")
}

public actual class PointerType public actual constructor(
  contained: Type,
  addrSpace: AddrSpace
) : CompositeType() {
  public override val count: Int
    get() = TODO("Not yet implemented")
}

public actual class IntegerType : Type() {
  public actual val constantNull: ConstantInt
    get() = TODO("Not yet implemented")
  public actual val allOnes: ConstantInt
    get() = TODO("Not yet implemented")
  public actual val typeWidth: Int
    get() = TODO("Not yet implemented")

  public actual fun getConstant(
    value: Int,
    unsigned: Boolean
  ): ConstantInt {
    TODO("Not yet implemented")
  }

  public actual fun getConstant(
    value: Long,
    unsigned: Boolean
  ): ConstantInt {
    TODO("Not yet implemented")
  }
}

public actual class FloatType : Type() {
  public actual val constantNull: ConstantFP
    get() = TODO("Not yet implemented")
  public actual val allOnes: ConstantFP
    get() = TODO("Not yet implemented")

  public actual fun getConstant(value: Float): ConstantFP {
    TODO("Not yet implemented")
  }

  public actual fun getConstant(value: Double): ConstantFP {
    TODO("Not yet implemented")
  }
}

public actual class FunctionType public actual constructor(
  returnType: Type,
  params: List<Type>,
  isVarargs: Boolean
) : Type() {
  public actual val returnType: Type
    get() = TODO("Not yet implemented")
  public actual val isVarargs: Boolean
    get() = TODO("Not yet implemented")
  public actual val parameters: List<Type>
    get() = TODO("Not yet implemented")
}

public actual class VoidType : Type()

public actual class LabelType : Type()

public actual class MetadataType : Type()

public actual class TokenType : Type()

public actual class X86MMXType : Type()
