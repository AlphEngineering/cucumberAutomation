Feature: Search Engine Functionality

  Scenario: Query search engine using Properties
    Given Search engine is loaded
    When 'Query' is entered using properties
    Then Site returns results

  Scenario Outline: Query search engine using Examples
    Given Search engine is loaded
    When '<Query>' is entered using examples
    Then Site returns results
    Examples:
    | Query |
    | Is 2024 El Nino or La Nina? |
    | How many hurricanes have crossed the Atlantic ocean in 2024? |