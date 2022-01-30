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

public actual sealed class ConstantExpr : Constant()

public actual class BinaryConstantExpr : ConstantExpr()

public actual class CompareConstantExpr : ConstantExpr()

public actual class ExtractElementConstantExpr : ConstantExpr()

public actual class ExtractValueConstantExpr : ConstantExpr()

public actual class GetElementPtrConstantExpr : ConstantExpr()

public actual class InsertElementConstantExpr : ConstantExpr()

public actual class InsertValueConstantExpr : ConstantExpr()

public actual class SelectConstantExpr : ConstantExpr()

public actual class ShuffleVectorConstantExpr : ConstantExpr()

public actual class UnaryConstantExpr : ConstantExpr()
