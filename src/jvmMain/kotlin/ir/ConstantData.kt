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

public actual sealed class ConstantData : Constant()

public actual class ConstantAggregate : ConstantData()

public actual sealed class ConstantDataSequential : ConstantData()

public actual class ConstantDataArray : ConstantDataSequential()

public actual class ConstantDataVector : ConstantDataSequential()
public actual class ConstantFP : ConstantData() {
  public actual val realValue: FPValue
    get() = TODO("Not yet implemented")
  public actual val value: Float
    get() = TODO("Not yet implemented")
}

public actual class ConstantInt : ConstantData() {
  public actual val zExtValue: Long
    get() = TODO("Not yet implemented")
  public actual val sExtValue: Long
    get() = TODO("Not yet implemented")
}

public actual class ConstantPointerNull : ConstantData()

public actual class ConstantTokenNone : ConstantData()

public actual sealed class UndefValue : ConstantData()

public actual class PoisonValue : UndefValue()
