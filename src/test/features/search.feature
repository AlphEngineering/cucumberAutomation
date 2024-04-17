Feature: Search Engine Functionality

  Scenario: Query search engine using Properties
    Given 'search_engine' is loaded
    When 'query' is entered
    Then site returns results

  Scenario Outline: Query search engine using Examples
    Given 'search_engine' is loaded
    When '<query>' is entered
    Then site returns results
    Examples:
    | query |
    | What companies are creating AI hardware? |
    | Is 2024 El Nino or La Nina? |
    | How many hurricanes have crossed the Atlantic ocean in 2024 |

