/*
 * Copyright 2014 Signal.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package co.signal.loadgen.example;

import java.util.Arrays;
import java.util.Map;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;


/**
* @author codyaray
* @since 6/30/14
*/
class SiteConfig {
  private final double weight;
  private final Map<String, PageConfig> pages;

  public SiteConfig(double weight, Map<String, PageConfig> pages) {
    this.weight = weight;
    this.pages = pages;
  }

  public double getWeight() {
    return weight;
  }

  public Map<String, PageConfig> getPages() {
    return pages;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("weight", weight)
        .add("pages", pages)
        .toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    } else if (obj == this) {
      return true;
    } else if (!getClass().isAssignableFrom(obj.getClass())) {
      return false;
    }
    return Arrays.equals(significantAttributes(), getClass().cast(obj).significantAttributes());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(significantAttributes());
  }

  Object[] significantAttributes() {
    return new Object[] { weight, pages };
  }
}
