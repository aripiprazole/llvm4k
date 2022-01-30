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

public actual sealed class GlobalObject : GlobalValue()

public actual class GlobalIFunc : GlobalObject() {
  public actual var resolver: Function?
    get() = TODO("Not yet implemented")
    set(value) {}

  public actual val hasResolver: Boolean
    get() = TODO("Not yet implemented")

  public actual fun erase() {
  }

  public actual fun delete() {
  }
}

public actual class GlobalVariable : GlobalObject() {
  public actual var threadLocal: Boolean
    get() = TODO("Not yet implemented")
    set(value) {}

  public actual var threadLocalMode: ThreadLocalMode
    get() = TODO("Not yet implemented")
    set(value) {}

  public actual var constant: Boolean
    get() = TODO("Not yet implemented")
    set(value) {}

  public actual var externallyInitialized: Boolean
    get() = TODO("Not yet implemented")
    set(value) {}

  public actual fun delete() {
  }
}

public actual class Function : GlobalObject() {
  public actual override val type: FunctionType
    get() = TODO("Not yet implemented")

  public actual val hasGC: Boolean
    get() = TODO("Not yet implemented")

  public actual val hasPersonalityFn: Boolean
    get() = TODO("Not yet implemented")

  public actual var personalityFn: Function?
    get() = TODO("Not yet implemented")
    set(value) {}

  public actual val arguments: List<Argument>
    get() = TODO("Not yet implemented")

  public actual val isVarargs: Boolean
    get() = TODO("Not yet implemented")

  public actual val returnType: Type
    get() = TODO("Not yet implemented")

  public actual var callingConv: CallingConv
    get() = TODO("Not yet implemented")
    set(value) {}

  public actual var gc: String?
    get() = TODO("Not yet implemented")
    set(value) {}
  public actual val blocks: List<BasicBlock>
    get() = TODO("Not yet implemented")

  public actual val entry: BasicBlock
    get() = TODO("Not yet implemented")

  public actual fun verify(action: VerifierFailureAction): Int {
    TODO("Not yet implemented")
  }

  public actual fun verify(): Boolean {
    TODO("Not yet implemented")
  }

  public actual fun appendBasicBlock(block: BasicBlock) {
  }

  public actual fun delete() {
  }

  public actual operator fun invoke(builder: Function.() -> Unit): Function {
    TODO("Not yet implemented")
  }
}
