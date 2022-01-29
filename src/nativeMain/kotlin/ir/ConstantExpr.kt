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

import llvm.LLVMGetInstructionOpcode
import llvm.LLVMValueRef
import org.plank.llvm4k.printToString

public actual sealed class ConstantExpr : Constant {
  public override fun toString(): String = printToString()
}

public actual class BinaryConstantExpr(public override val ref: LLVMValueRef?) :
  ConstantExpr()

public actual class CompareConstantExpr(public override val ref: LLVMValueRef?) :
  ConstantExpr()

public actual class ExtractElementConstantExpr(public override val ref: LLVMValueRef?) :
  ConstantExpr()

public actual class ExtractValueConstantExpr(public override val ref: LLVMValueRef?) :
  ConstantExpr()

public actual class GetElementPtrConstantExpr(public override val ref: LLVMValueRef?) :
  ConstantExpr()

public actual class InsertElementConstantExpr(public override val ref: LLVMValueRef?) :
  ConstantExpr()

public actual class InsertValueConstantExpr(public override val ref: LLVMValueRef?) :
  ConstantExpr()

public actual class SelectConstantExpr(public override val ref: LLVMValueRef?) :
  ConstantExpr()

public actual class ShuffleVectorConstantExpr(public override val ref: LLVMValueRef?) :
  ConstantExpr()

public actual class UnaryConstantExpr(public override val ref: LLVMValueRef?) :
  ConstantExpr()

@Suppress("ComplexMethod", "LongMethod")
public fun ConstantExpr(ref: LLVMValueRef?): ConstantExpr {
  return when (val opcode = Opcode.byValue(LLVMGetInstructionOpcode(ref))) {
    Opcode.Add -> BinaryConstantExpr(ref)
    Opcode.FAdd -> BinaryConstantExpr(ref)
    Opcode.Sub -> BinaryConstantExpr(ref)
    Opcode.FSub -> BinaryConstantExpr(ref)
    Opcode.Mul -> BinaryConstantExpr(ref)
    Opcode.FMul -> BinaryConstantExpr(ref)
    Opcode.UDiv -> BinaryConstantExpr(ref)
    Opcode.SDiv -> BinaryConstantExpr(ref)
    Opcode.FDiv -> BinaryConstantExpr(ref)
    Opcode.URem -> BinaryConstantExpr(ref)
    Opcode.SRem -> BinaryConstantExpr(ref)
    Opcode.FRem -> BinaryConstantExpr(ref)
    Opcode.Shl -> BinaryConstantExpr(ref)
    Opcode.LShr -> BinaryConstantExpr(ref)
    Opcode.AShr -> BinaryConstantExpr(ref)
    Opcode.And -> BinaryConstantExpr(ref)
    Opcode.Or -> BinaryConstantExpr(ref)
    Opcode.Xor -> BinaryConstantExpr(ref)
    Opcode.GetElementPtr -> GetElementPtrConstantExpr(ref)
    Opcode.ICmp -> CompareConstantExpr(ref)
    Opcode.FCmp -> CompareConstantExpr(ref)
    Opcode.ExtractElement -> ExtractElementConstantExpr(ref)
    Opcode.InsertElement -> InsertElementConstantExpr(ref)
    Opcode.ShuffleVector -> ShuffleVectorConstantExpr(ref)
    Opcode.ExtractValue -> ExtractValueConstantExpr(ref)
    Opcode.InsertValue -> InsertValueConstantExpr(ref)
    Opcode.FNeg -> UnaryConstantExpr(ref)
    else -> error("Unsupported constant expression $opcode")
  }
}
