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

public expect enum class AtomicRMWBinOp {
  Xchg,
  Add,
  Sub,
  And,
  Nand,
  Or,
  Xor,
  Max,
  Min,
  UMax,
  UMin,
  FAdd,
  FSub;

  public val value: UInt

  public companion object {
    public fun byValue(value: Int): AtomicRMWBinOp

    public fun byValue(value: UInt): AtomicRMWBinOp
  }
}
