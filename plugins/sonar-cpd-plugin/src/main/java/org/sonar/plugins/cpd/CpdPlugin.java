/*
 * Sonar, open source software quality management tool.
 * Copyright (C) 2008-2012 SonarSource
 * mailto:contact AT sonarsource DOT com
 *
 * Sonar is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * Sonar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Sonar; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.cpd;

import com.google.common.collect.ImmutableList;
import org.sonar.api.*;
import org.sonar.plugins.cpd.decorators.DuplicationDensityDecorator;
import org.sonar.plugins.cpd.decorators.SumDuplicationsDecorator;
import org.sonar.plugins.cpd.index.IndexFactory;

import java.util.List;

@Properties({
  @Property(
    key = CoreProperties.CPD_CROSS_RPOJECT,
    defaultValue = CoreProperties.CPD_CROSS_RPOJECT_DEFAULT_VALUE + "",
    name = "Cross project duplicaton detection",
    description = "Sonar supports the detection of cross project duplications." +
      " Activating this property will slightly increase each Sonar analysis time." +
      " This mode can't be used along with the PMD CPD engine.",
    project = true,
    module = true,
    global = true,
    category = CoreProperties.CATEGORY_DUPLICATIONS,
    type = PropertyType.BOOLEAN)
})
public final class CpdPlugin extends SonarPlugin {

  public List<Class<? extends BatchExtension>> getExtensions() {
    return ImmutableList.of(
        CpdSensor.class,
        SumDuplicationsDecorator.class,
        DuplicationDensityDecorator.class,
        IndexFactory.class,
        SonarEngine.class,
        SonarBridgeEngine.class);
  }

}
