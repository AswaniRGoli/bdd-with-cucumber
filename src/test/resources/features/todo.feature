Feature: Todo.feature

#########################################################################################
  #Purpose: Ensure that create TODO items are displayed
  # '"'
  #Ensure that the created TODO items are displayed in the TODO list
  #
  #Ensure that the completed TODO items are displayed in the TODO list
  #
  #Ensure that count of TODO items left
#########################################################################################
  Scenario: User able to view the TODO items and completed items
    Given the user opened the TODO page
    When user created the following TODO items
      | item1 |
      | item2 |
      | item3 |
    Then the following items are displayed in TODO list
      | item1 |
      | item2 |
      | item3 |
    When user completes the following TODO items
      | item1 |
    Then the following items are marked as completed
      | item1 |
    And the following items are shown as to do
      | item2 |
      | item3 |
    And the count of TODO items is shown as "2 items left"


#########################################################################################
  #Purpose: Ensure that user able to delete the TODO items
  # '"'
  #Ensure that TODO are deleted
  #
  #Ensure that  completed items are deleted
#########################################################################################
  Scenario: User able to delete the TODO items and completed items
    Given the user opened the TODO page
    When user created the following TODO items
      | item1 |
      | item2 |
      | item3 |
    Then the following items are displayed in TODO list
      | item1 |
      | item2 |
      | item3 |
    When user completes the following TODO items
      | item1 |
    And User deletes the following 'Completed' items
      | item1 |
    Then the following 'Completed' items are deleted
      | item1 |
    When User deletes the following 'TODO' items
      | item2 |
      | item3 |
    Then the following 'TODO' items are deleted
      | item2 |
      | item3 |

#########################################################################################
  #Purpose: Ensure that user able to delete the TODO list
  # '"'
  #Ensure that all TODO is deleted
#########################################################################################
  Scenario: User able to delete todo list
    Given the user opened the TODO page
    When user created the following TODO items
      | item1 |
      | item2 |
      | item3 |
    Then the following items are displayed in TODO list
      | item1 |
      | item2 |
      | item3 |
    When user completes the following TODO items
      | item1 |
    And User deletes the following 'All' items
      | item1 |
      | item2 |
      | item3 |
    Then the following 'All' items are deleted
      | item1 |
      | item2 |
      | item3 |

#########################################################################################
  #Purpose: Ensure that user able to filter the TODO items
  # '"'
  #Ensure that active items are displayed when Active items filtered
  #
  #Ensure that completed items are displayed when Completed items filtered
  #
   #Ensure that all items are displayed when ALL items filtered
#########################################################################################
  Scenario: User able to filter the Active and completed todo items by selecting footer links
    Given the user opened the TODO page
    When user created the following TODO items
      | item1 |
      | item2 |
      | item3 |
    Then the following items are displayed in TODO list
      | item1 |
      | item2 |
      | item3 |
    When user completes the following TODO items
      | item1 |
    And user selects option "Completed"
    Then All completed items are displayed
      | item1 |
    When user selects option "All"
    Then All the completed and TODO items are displayed
      | item1 |
      | item2 |
      | item3 |
    When user selects option "Active"
    Then All active TODO items are displayed
      | item2 |
      | item3 |

#########################################################################################
  #Purpose: Ensure that user able to delete items by clear completed option
  # '"'
  #Ensure that only completed items are deleted when Clear completed is selected
#########################################################################################
  Scenario: User able to deleted only completed items by clear completed
    Given the user opened the TODO page
    When user created the following TODO items
      | item1 |
      | item2 |
      | item3 |
    Then the following items are displayed in TODO list
      | item1 |
      | item2 |
      | item3 |
    When user completes the following TODO items
      | item1 |
    When user selects option "Clear completed"
    Then the following 'Completed' items are deleted
      | item1 |
    Then the following items are displayed in TODO list
      | item2 |
      | item3 |
    When user completes the following TODO items
      | item2 |
      | item3 |
    When user selects option "Clear completed"
    Then the following 'Completed' items are deleted
      | item2 |
      | item3 |

 #########################################################################################
  #Purpose: Ensure that user able to modify the TODO items
  # '"'
  #Ensure that TODO items are modified
#########################################################################################
  Scenario: User able to edit the todo items
    Given the user opened the TODO page
    When user created the following TODO items
      | item1 |
    Then the following items are displayed in TODO list
      | item1 |
    When User modifies the following "TODO" item to "test item"
      | item1 |
    Then the "TODO" item is modified to "test item" in TODO list

 #########################################################################################
  #Purpose: Ensure that user able to modify the completed items
  # '"'
  #Ensure that completed items are modified
#########################################################################################
  Scenario: User able to edit the todo completed items
    Given the user opened the TODO page
    When user created the following TODO items
      | item1 |
    Then the following items are displayed in TODO list
      | item1 |
    When user completes the following TODO items
      | item1 |
    And User modifies the following "Completed" item to "test item"
      | item1 |
    Then the "Completed" item is modified to "test item" in TODO list

