/**
 * (c) Copyright 2019-2020 IBM Corporation
 * 1 New Orchard Road, 
 * Armonk, New York, 10504-1722
 * United States
 * +1 914 499 1900
 * support: Nathaniel Mills wnm3@us.ibm.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

/*
 * Copyright 2011 OverZealous Creations, LLC
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

package com.overzealous.remark.convert;

import com.api.json.JSONObject;
import com.mdfromhtml.core.MDfromHTMLUtils;
import com.overzealous.remark.Options;
import com.overzealous.remark.Remark;
import org.junit.Test;

/**
 * @author Phil DeJarnett
 */
public class MultiMarkdownTest extends RemarkTester {

   @Override
   public Remark setupRemark() {
      JSONObject HTMLFilters = null;
      try {
         HTMLFilters = MDfromHTMLUtils.loadJSONFile("HTML_Filters.json");
      } catch (Exception e1) {
         System.out.println(
            "Warning: Using no HTML Filters -- can not find \"HTML_Filters.json\": "
               + e1.getLocalizedMessage());
         JSONObject globalFilter = new JSONObject();
         globalFilter.put(":all", new JSONObject());
         HTMLFilters = new JSONObject();
         HTMLFilters.put("*", globalFilter);
      }
      Options options = Options.multiMarkdown();
      // options.hardwraps = true;
      return new Remark(options, HTMLFilters);
   }

   @Test
   public void testAbbr() throws Exception {
      test("abbr");
   }

   @Test
   public void testAnchor() throws Exception {
      test("anchor");
   }

   @Test
   public void testBlockQuote() throws Exception {
      test("blockquote");
   }

   @Test
   public void testHeader() throws Exception {
      test("header");
   }

   @Test
   public void testBreak() throws Exception {
      test("break");
   }

   @Test
   public void testCodeblock() throws Exception {
      test("codeblock");
   }

   @Test
   public void testDefinitions() throws Exception {
      test("definitions", "enabled");
   }

   @Test
   public void testHorizontalRule() throws Exception {
      test("horizontalrule");
   }

   @Test
   public void testImage() throws Exception {
      test("image");
   }

   @Test
   public void testInlineCode() throws Exception {
      test("inlinecode");
   }

   @Test
   public void testInlineStyle() throws Exception {
      test("inlinestyle");
   }

   @Test
   public void testListOrdered() throws Exception {
      test("listordered");
   }

   @Test
   public void testListUnordered() throws Exception {
      test("listunordered");
   }

   @Test
   public void testParagraph() throws Exception {
      test("paragraph");
   }

   @Test
   public void testTables() throws Exception {
      test("tables", "multimarkdown");
   }

   @Test
   public void testUnknownHTML() throws Exception {
      test("unknownHTML");
   }

}
