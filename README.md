# InPost Recruitment Task

## TODO
- Add pull to refresh
- Refactor activity and fragment to run ShipmentListScreen
- Add WorkManager for cyclical data refreshing in :data module
- Add LocalDataSource with Room in :data:database module. Implement proper items sorting in query
- Add screenshot tests
- Update README with screenshots, project description and architecture decisions explanation (i.ex. why dummy UseCases)
- Add polish translations to shipmentlist module

## Intro
We travel back in time ⏱️. InPost Mobile app was just created and you join the team to improve its feature set and make it ready for the future.
User base is growing fast and every day more people start to use it daily.

You, as an experienced developer, were assigned to the project to improve its quality. The initial code is not perfect and is far from being.
Organize and refactor code the way you like to work (packages, modules, layers, data flow, names, methods order etc.).

## Rules
- You can change and move any part you like (except JSON file), install any open source library you want
- A static JSON file is returned in response, **consider this is a real production environment** returning your data
- JSON file cannot be changed
- Git history is also important
- Feel free to comment your choices

## Tasks
1. Add grouping to the list of Shipments by flag **ShipmentNetwork.operations.highlight**
2. Style list items as in Figma (link: https://www.figma.com/file/E7vZMYESnKvmzn70FenrhP/InPost)
3. Sort list items in groups by (the closest date to current date should be at top of the list):
    * status - order is described in `ShipmentStatus.kt` file (the higher order, the higher it should be on the list)
    * pickupDate
    * expireDate
    * storedDate
    * number
4. Add pull to refresh and handle refresh progress
5. Add storing shipments locally (use Room)
6. Add local archiving of the shipment:
    * We consider archiving as hiding the shipment from the list of `Shipment`s
    * Design is not important here
    * `Shipment` must stay hidden after re-downloading data or relaunching the app
    * Use flag **ShipmentNetwork.operations.manualArchive**
7. Create unit tests

## Links and resources
- Fonts folder: [/app/src/main/res/font](./app/src/main/res/font)

If for some reason Figma link stops working, here you can see the requested design:
![Design from Figma](./images/Figma.png)

# Good luck! 💪
