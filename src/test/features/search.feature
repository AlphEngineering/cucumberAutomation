Feature: Search Engine Functionality

  Scenario: Query search engine using Properties
    Given search engine is loaded
    When a 'query' is entered using properties
    Then site returns results

  Scenario Outline: Query search engine using Examples
    Given search engine is loaded
    When a '<query>' is entered using examples
    Then site returns results
    Examples:
    | query |
    | Is 2024 El Nino or La Nina? |
    | How many hurricanes have crossed the Atlantic ocean in 2024 |

