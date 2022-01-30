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

import org.plank.llvm4k.Module

public actual sealed class GlobalValue : Constant(), NamedValue {
  public actual open var linkage: Linkage
    get() = TODO("Not yet implemented")
    set(value) {}

  public actual open var visibility: Visibility
    get() = TODO("Not yet implemented")
    set(value) {}

  public actual open var section: String?
    get() = TODO("Not yet implemented")
    set(value) {}

  public actual open var dllStorageClass: DLLStorageClass
    get() = TODO("Not yet implemented")
    set(value) {}

  public actual open var unnamedAddr: UnnamedAddr
    get() = TODO("Not yet implemented")
    set(value) {}

  public actual open val module: Module
    get() = TODO("Not yet implemented")

  public actual open val valueType: Type
    get() = TODO("Not yet implemented")
}

public actual class GlobalAlias : GlobalValue() {
  public actual var aliasee: Constant
    get() = TODO("Not yet implemented")
    set(value) {}
}
