# Empower code assessment app
initial screen displays a list of beneficiary data, clicks on list items navigates to a detail data
screen

## MVVM architecture with a single activity hosting fragments. Fragment switching / navigation
 done via function call to the hosting main activity's replaceFragment function.
 
## Repository pattern - 
repository contains json parsing functions and any additional remote or local data functions can be
added to contain all data access functionality in repository.

## ViewModel -
ViewModel utilizes LiveData to provision list of Beneficiary class data and to update UI with data

## Improvement suggestions-
Use of XML,3rd party libraries has been restrained to meet assessment requirements, but use of
Gson for deserialization, xml layouts for building and seperation of UI building code, navigation
component for organization and implementation of navigation, argument passing and animations, as well
as use of Retrofit for building a network layer for remote and local sources while utilizing coroutine benefits
for asynchronous network calls, as well as unit testing of view model functions are suggestions 
which could improve the app. Optimally jetpack compose would offer benefit in performance optimization
and reduction in required boiler plate code.

additionally, organizing project files within project structure using packages would be an improvement.
