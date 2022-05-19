Feature: Nyp Search Scenarios

  Background: Authenticate Page

    Given navigate to Search Page
    Then Provide Authentication to the page


  Scenario: Search Page Title Check

    When identify Search Page title
    Then page title should be "Search Results | NYP"

  Scenario: WildCard Asterisk Check

    When Provide Search Input "test*"
    Then Search Results Should Display "test"

  Scenario: WildCard Question Check

    When Provide Search Input "t?st"
    Then Search Results Should Display "test"

  Scenario: Fuzzy Search Operator Check

    When Provide Search Input "good~"
    Then Search Results Should Display "good"

  Scenario: Proximity Search Check

    When Provide Search Input "NewYork doctor ~ 2"
    Then Search Results Should Display "NewYork"

  Scenario: Phrase Search Check

    When Provide Search Input "\"NewYork Presbyterian\""
    Then Search Results Should Display "NewYork"

  Scenario: BooleanAND Search Check

    When Provide Search Input "Patients AND visitors"
    Then Search Results Should Display "Patients"

  Scenario: BooleanOR Search Check

    When Provide Search Input "Patients OR Heartattack"
    Then Search Results Should Display "Patients"

  Scenario: BooleanNOT Search Check

    When Provide Search Input "NewYork NOT test"
    Then Search Results Should Display "NewYork"

  Scenario: Plus Operator Search Check

    When Provide Search Input "+Doctor Hospital"
    Then Search Results Should Display "Doctor"

  Scenario: Prohibit Search Check

    When Provide Search Input "Cancer -search"
    Then Search Results Should Display "Cancer"

  Scenario: Escape Operator(\) Search Check

    When Provide Search Input "Doctor'\'"
    Then Search Results Should Display "Doctor"

  Scenario: Special Character ($) Search Check

    When Provide Search Input "NewYork$"
    Then Search Results Should Display "NewYork"

  Scenario: Special Character (@) Search Check

    When Provide Search Input "Cancer@"
    Then Search Results Should Display "Cancer"


  Scenario: Special Character (&) Search Check

    When Provide Search Input "Cancer&"
    Then Search Results Should Display "Cancer"

  Scenario: Special Character ({}) Search Check

    When Provide Search Input "Hospital{}"
    Then Search Results Should Display "Hospital"

  Scenario: Fielded Title Search Check

    When Provide Search Input "title:\"NYM Debuts Interventional Neuroradiology | NYP\""
    Then Search Results Should Display "NYP"

  Scenario: Fielded Description Search Check

    When Provide Search Input "description:\"Methodist Hospital\""
    Then Search Results Should Display "Methodist"

  Scenario: Fielded URL Search Check

    When Provide Search Input "url:\"https://www.nyp.org/news/new-catheterless-technique-may-ease-pain-of-prostate-cancer\""
    Then Search Results Should Display "cancer"

  Scenario: Fielded Content Search Check

    When Provide Search Input "content:Cancer"
    Then Search Results Should Display "Cancer"

  Scenario: Fielded ContentType Search Check

    When Provide Search Input "contenttype:html"
    Then Search Results Should Display "Cancer"

  Scenario: Fielded Language Search Check

    When Provide Search Input "language:en"
    Then Search Results Should Display "Drug"

  Scenario: Fielded Grouping1 Search Check

    When Provide Search Input "content:hospital AND contenttype:html"
    Then Search Results Should Display "Hospital"

  Scenario: Fielded Grouping2 Search Check

    When Provide Search Input "+cancer +doctor +(content:hospital)"
    Then Search Results Should Display "Cancer"

  Scenario: Fielded Grouping3 Search Check

    When Provide Search Input "((drug AND cancer) OR keywords:Maths) AND hospital"
    Then Search Results Should Display "Cancer"

  Scenario: Fielded Grouping4 Search Check

    When Provide Search Input "search ~ searching"
    Then Search Results Should Display "Search"

  Scenario: Spell Correction Check

    When Provide Search Input "drugi"
    Then Search Results Should Display "Drug"

  Scenario:AutoSuggestion Check

    When Check for the AutoSuggest
    Then Search Results Should Display "Patient"

  Scenario:URL Filter Check

    When Provide Search Input "url:/news"
    Then Search Results Should Display "Cancer"

  Scenario:URL Negative Filter Check

    When Provide Search Input "-url:/news"
    Then Search Results Should Display "NewYork"


  Scenario: Invalid Query Search

    When Provide Search Input "ddfsafsafaf@!!#@$R$#^&"
    Then Search Results for the invalid query Should Display "ddfsafsafaf@!!#@$R$#^&"