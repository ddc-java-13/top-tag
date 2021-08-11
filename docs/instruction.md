---
title: Instructions
subtitle: Build Instructions and Instructions
menu: Instructions
order: 50
---

Build Instructions

## [Github Link](https://github.com/ddc-java-13/top-tag)

* Click on "Code"
* Selecet SSH, copy to clipboard.
* In your IDE create new from VCS.
* Paste the link and create.  Trust source.

## Gradle Build

* Add below to build.gradle(module) **dependencies**
  // Google Maps libraries
  implementation 'com.google.android.gms:play-services-maps:17.0.1'
  implementation 'com.google.maps.android:android-maps-utils:2.2.3'

## API Key

* Go to credential site.
[Credentials](https://console.cloud.google.com/project/_/google/maps-apis/credentials?_ga=2.141576498.1801649734.1628648152-1982963209.1628648152)
* Create account if required.
* On the Credentials page, click Create credentials > API key.
* The API key created dialog displays your newly created API key and will be under your credentials page.

## Android Manifest

* In the AndroidManifest.xml file add"

<meta-data
android:name="com.google.android.geo.API_KEY"
android:value="${MAPS_API_KEY}" />

## Properties File

* In your projects level directory add the following code.
google_maps_key = [enter api key here.  REMOVE THE BRACKETS! ]
   
  
App Instructions

#### Map
Map overlay shows all the hunt management zones of new mexico.  Click on the unit dot to verify unit number.

#### Hunt
The default ALL display will show all weapon and season info.  Selecting Archery will only show archery units, and Rifle will select only rifle units.
The seasons will correspond to the weapon.  Archery seasons are September and will not show if October is selected.
Rifle season is October and will not display units if September is selected.

#### Notes
Under Construction, check back later.
