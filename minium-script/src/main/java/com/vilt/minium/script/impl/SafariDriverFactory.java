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
package com.vilt.minium.script.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import com.google.common.base.Objects;

public class SafariDriverFactory implements WebDriverFactory {

    @Override
    public boolean supports(DesiredCapabilities capabilities) {
        return Objects.equal(BrowserType.SAFARI, capabilities.getBrowserName());
    }

    @Override
    public WebDriver create(DesiredCapabilities capabilities) {
        return new SafariDriver(capabilities);
    }

    @Override
    public void destroy() {
    }
}
