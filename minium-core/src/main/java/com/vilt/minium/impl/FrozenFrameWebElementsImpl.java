/*
 * Copyright (C) 2013 The Minium Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vilt.minium.impl;

import static com.google.common.base.Preconditions.checkState;

import java.util.Collections;
import java.util.Iterator;

import com.vilt.minium.CoreWebElements;
import com.vilt.minium.WebElementsDriver;

public class FrozenFrameWebElementsImpl<T extends CoreWebElements<T>> extends FrameWebElementsImpl<T> {

    private WebElementsDriver<T> frozenWebElementsDriver;

    @Override
    public Iterable<WebElementsDriver<T>> candidateWebDrivers() {
        if (frozenWebElementsDriver == null) {
            Iterable<WebElementsDriver<T>> candidateWebDrivers = super.candidateWebDrivers();
            Iterator<WebElementsDriver<T>> iterator = candidateWebDrivers.iterator();
            if (iterator.hasNext()) {
                WebElementsDriver<T> webElementsDriver = iterator.next();
                checkState(!iterator.hasNext(), "Found more than one frame / iframe matching the filter condition");
                frozenWebElementsDriver = webElementsDriver;
            }
        }
        if (frozenWebElementsDriver == null) {
            return Collections.<WebElementsDriver<T>>emptyList();
        } else {
            return Collections.<WebElementsDriver<T>>singletonList(frozenWebElementsDriver);
        }
    }

}
