$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Leumit_assignment.feature");
formatter.feature({
  "line": 3,
  "name": "Assignment to get table content by search value or index",
  "description": "",
  "id": "assignment-to-get-table-content-by-search-value-or-index",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Leumit-table-assignment"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "User go to table website and search for a value",
  "description": "",
  "id": "assignment-to-get-table-content-by-search-value-or-index;user-go-to-table-website-and-search-for-a-value",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "I go to the table website and get table",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I load data from config by choosing column index \"0\" and row index \"5\"",
  "keyword": "Then "
});
formatter.step({
  "comments": [
    {
      "line": 9,
      "value": "#first value is between 0-2, and needs to be the same as value in next step search value"
    },
    {
      "line": 10,
      "value": "#second value can be random from 0-5"
    }
  ],
  "line": 12,
  "name": "I choose search value in column \"0\" and return value in column \"2\"",
  "keyword": "When "
});
formatter.step({
  "comments": [
    {
      "line": 13,
      "value": "#can be either index from 0-2 or column name (Country, Contact, Name)"
    }
  ],
  "line": 14,
  "name": "I verify the cell text with my text \"Italy\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.I_go_to_the_table_website()"
});
formatter.result({
  "duration": 31114414708,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 50
    },
    {
      "val": "5",
      "offset": 68
    }
  ],
  "location": "Steps.loadDataFromConfig(int,int)"
});
formatter.result({
  "duration": 7156584,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 33
    },
    {
      "val": "2",
      "offset": 64
    }
  ],
  "location": "Steps.EnterSearchParameters(String,String)"
});
formatter.result({
  "duration": 4298287458,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Italy",
      "offset": 37
    }
  ],
  "location": "Steps.VerifyTextWithOwnText(String)"
});
formatter.result({
  "duration": 707875,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "User go to table website and search for a value by XPath",
  "description": "",
  "id": "assignment-to-get-table-content-by-search-value-or-index;user-go-to-table-website-and-search-for-a-value-by-xpath",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 17,
  "name": "I go to the table website and get table",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "I choose by xpath in row \"2\" and in column \"1\"",
  "keyword": "Then "
});
formatter.step({
  "comments": [
    {
      "line": 20,
      "value": "#First value between 2-6"
    },
    {
      "line": 21,
      "value": "#second value between 1-3"
    }
  ],
  "line": 22,
  "name": "I verify the cell text with my text \"Alfreds Futterkiste\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.I_go_to_the_table_website()"
});
formatter.result({
  "duration": 27192934208,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 26
    },
    {
      "val": "1",
      "offset": 44
    }
  ],
  "location": "Steps.EnterXPathParameters(int,int)"
});
formatter.result({
  "duration": 686747750,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Alfreds Futterkiste",
      "offset": 37
    }
  ],
  "location": "Steps.VerifyTextWithOwnText(String)"
});
formatter.result({
  "duration": 340083,
  "status": "passed"
});
});