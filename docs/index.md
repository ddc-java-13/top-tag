---
title: Overview
subtitle: Project description and status
menu: Overview
order: 0
---

## Summary

The purpose of the Top Tag App is to show each Game Management Unit and dispaly odds of recieving a
tag.

The app will sort the size of the herds per each Game Management Unit, calculate how many people
applied in the draw for a tag with how many people recieved a tag. This will allow the user to
see his or her odds of drawing an elk tag in each Game Management Unit.

Furthermore, this app will calculate draw odds for each legal weapon and corresponding seasons for Antlered and
Antlerless hunts.

## Intended users

  * Elk hunters:

> As a hunter, I want an app that can decipher game harvest reports to show me the percentage of tags issued per tag application, this will increase my channces of successfully drawing a tag without wading through lists of data.


  * Shed hunters:

> As a shed hunter, I want to see which Game Management Units have the largest herds across the state of New Mexico, this will allow me to hike in the areas and increase my odds of finding shed antlers.

## Functionality

* The app will show a satelite view of New Mexico with each Game Management Unit overlayed on the
  map of New Mexico to the viewer.
* The user will use a hamburger menu to select the animal type (Antlered, Antlerless) to be hunted.
* The user will expand the menu to select the weapon type.
* The user will expand the menu for the date range of the season.
* The app will dispaly herd numbers for previous year, tag applications, tag draws, and harvest
  reports.
* Using radio buttons, the user can select which data to display. The user can use a radio button to
  choose whether the selected data will display inside each corresponding hunt region or in a list of units
  on the side of the screen. For example:

    * Unit 1 - xx
    * Unit 2 - xx
    * Unit 3B - xx

## Persistent data

* Herd numbers
* Draw statistics
  * Number of applicants
  * Number of tags issued
  * Elk harvests
  
* Database Management <a href="https://developer.android.com/training/data-storage/room">Room API</a>
* New Mexico Game & Wildlife <a href="https://www.wildlife.state.nm.us/download/hunting/species/elk/Elk-Hunting-Prospects-2021-2022-.pdf">Elk Hunting Prospects 2021-2022</a>

  Top Tag will function while away from internet services to incorporate stretch goals.

## Device/external services

* Map <a href="https://developers.google.com/maps/documentation/android-sdk/tileoverlay">Tile Overlays API</a>

## Stretch goals/enhancements

* Storing a copy of users hunting and fishing licenses and E-tags.
* Incorporate for all game animals that require draw. The app is current designed for Elk. Future versions of the build
  will incorporate Black Bear, Deer, Turkey, Oryx, Barbary Sheep, Javelina, and Prong Horn.
* Incorporate all "Over the Counter" game that do not require tag draw. This would be for non-draw
  required Black Bear, Turkey, and Barbary Sheep.
* Incorporate satellite data and user location for map/traveling distance between user location and
  destination and to identify key locations such as camp grounds and trail access.

