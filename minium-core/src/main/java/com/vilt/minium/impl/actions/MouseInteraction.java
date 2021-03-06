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
package com.vilt.minium.impl.actions;

import org.openqa.selenium.WebElement;

import com.vilt.minium.CoreWebElements;
import com.vilt.minium.Dimension;
import com.vilt.minium.Offsets.Offset;
import com.vilt.minium.Point;

/**
 * The Class MouseInteraction.
 */
public abstract class MouseInteraction extends DefaultInteraction {

    protected Offset offset;

    /**
     * Instantiates a new mouse interaction.
     *
     * @param elems the elems
     * @param offset
     */
    public MouseInteraction(CoreWebElements<?> elems, Offset offset) {
        super(elems);
        this.offset = offset;
    }

    protected Point getOffsetPoint(WebElement source) {
        if (source != null && offset != null) {
            org.openqa.selenium.Dimension size = source.getSize();
            Dimension dimension = new Dimension(size.width, size.height);
            return offset.offset(dimension);
        }
        return null;
    }

}
