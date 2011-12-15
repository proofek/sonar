/*
 * Sonar, open source software quality management tool.
 * Copyright (C) 2008-2011 SonarSource
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
package org.sonar.api.web.dashboard;

import org.junit.Test;

import java.util.Map.Entry;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class WidgetTest {

  @Test
  public void shouldCreateWidget() {
    Dashboard dashboard = Dashboard.createByName("Fake");
    Dashboard.Widget widget = dashboard.addWidget("fake-widget", 1);
    assertThat(widget.getId(), is("fake-widget"));
  }

  @Test
  public void shouldSetProperty() {
    Dashboard dashboard = Dashboard.createByName("Fake");
    Dashboard.Widget widget = dashboard.addWidget("fake-widget", 1);
    widget.setProperty("foo", "bar");

    assertThat(widget.getProperties().get("foo"), is("bar"));
  }

}