/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dromara.workflow.controller;

import cn.hutool.core.io.resource.ResourceUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author Tijs Rademakers
 */
@RestController
@RequestMapping("/workflow/model")
public class StencilsetRestResource {

    @GetMapping(value = "/rest/stencil-sets/editor")
    public String getStencilset() {
        try (InputStream inputStream = ResourceUtil.getStream("static/stencilset.json")) {
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new SecurityException("Error while loading stencil set", e);
        }
    }
}
