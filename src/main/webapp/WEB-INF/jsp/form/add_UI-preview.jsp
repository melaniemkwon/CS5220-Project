<!doctype html>
<!--
  Material Design Lite
  Copyright 2015 Google Inc. All rights reserved.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      https://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License
-->
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="A front-end template that helps you build fast, modern mobile web apps.">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
    <title>Formbuilder</title>

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="images/android-desktop.png">

    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Material Design Lite">
    <link rel="apple-touch-icon-precomposed" href="images/ios-desktop.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="images/touch/ms-touch-icon-144x144-precomposed.png">
    <meta name="msapplication-TileColor" content="#3372DF">

    <link rel="shortcut icon" href="images/favicon.png">

    <!-- SEO: If your mobile URL is different from the desktop URL, add a canonical link to the desktop page https://developers.google.com/webmasters/smartphone-sites/feature-phones -->
    <!--
    <link rel="canonical" href="http://www.example.com/">
    -->

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.blue-indigo.min.css" />
     
    <!-- Not sure why i get an error importing styles.css -->
    <link rel="stylesheet" href="styles.css">
    <style>
/**
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

html, body {
  font-family: 'Roboto', 'Helvetica', sans-serif;
  margin: 0;
  padding: 0;
}
.mdl-demo .mdl-layout__header-row {
  padding-left: 40px;
}
.mdl-demo .mdl-layout.is-small-screen .mdl-layout__header-row h3 {
  font-size: inherit;
}
.mdl-demo .mdl-layout__tab-bar-button {
  display: none;
}
.mdl-demo .mdl-layout.is-small-screen .mdl-layout__tab-bar .mdl-button {
  display: none;
}
.mdl-demo .mdl-layout:not(.is-small-screen) .mdl-layout__tab-bar,
.mdl-demo .mdl-layout:not(.is-small-screen) .mdl-layout__tab-bar-container {
  overflow: visible;
}
.mdl-demo .mdl-layout__tab-bar-container {
  height: 64px;
}
.mdl-demo .mdl-layout__tab-bar {
  padding: 0;
  padding-left: 16px;
  box-sizing: border-box;
  height: 100%;
  width: 100%;
}
.mdl-demo .mdl-layout__tab-bar .mdl-layout__tab {
  height: 64px;
  line-height: 64px;
}
.mdl-demo .mdl-layout__tab-bar .mdl-layout__tab.is-active::after {
  background-color: white;
  height: 4px;
}
.mdl-demo main > .mdl-layout__tab-panel {
  padding: 8px;
  padding-top: 48px;
}
.mdl-demo .mdl-card {
  height: auto;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-flex-direction: column;
      -ms-flex-direction: column;
          flex-direction: column;
}
.mdl-demo .mdl-card > * {
  height: auto;
}
.mdl-demo .mdl-card .mdl-card__supporting-text {
  margin: 40px;
  -webkit-flex-grow: 1;
      -ms-flex-positive: 1;
          flex-grow: 1;
  padding: 0;
  color: inherit;
  width: calc(100% - 80px);
}
.mdl-demo.mdl-demo .mdl-card__supporting-text h4 {
  margin-top: 0;
  margin-bottom: 20px;
}
.mdl-demo .mdl-card__actions {
  margin: 0;
  padding: 4px 40px;
  color: inherit;
}
.mdl-demo .mdl-card__actions a {
  color: #00BCD4;
  margin: 0;
}
.mdl-demo .mdl-card__actions a:hover,
.mdl-demo .mdl-card__actions a:active {
  color: inherit;
  background-color: transparent;
}
.mdl-demo .mdl-card__supporting-text + .mdl-card__actions {
  border-top: 1px solid rgba(0, 0, 0, 0.12);
}
.mdl-demo #add {
  position: absolute;
  right: 40px;
  top: 36px;
  z-index: 999;
}

.mdl-demo .mdl-layout__content section:not(:last-of-type) {
  position: relative;
  /*margin-bottom: 48px;*/
  margin-bottom: 1px;
}
.mdl-demo section.section--center {
  max-width: 860px;
}
.mdl-demo #features section.section--center {
  max-width: 620px;
}
.mdl-demo section > header{
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-align-items: center;
      -ms-flex-align: center;
          align-items: center;
  -webkit-justify-content: center;
      -ms-flex-pack: center;
          justify-content: center;
}
.mdl-demo section > .section__play-btn {
  min-height: 200px;
}
.mdl-demo section > header > .material-icons {
  font-size: 3rem;
}
.mdl-demo section > button {
  position: absolute;
  z-index: 99;
  top: 8px;
  right: 8px;
}
.mdl-demo section .section__circle {
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-align-items: center;
      -ms-flex-align: center;
          align-items: center;
  -webkit-justify-content: flex-start;
      -ms-flex-pack: start;
          justify-content: flex-start;
  -webkit-flex-grow: 0;
      -ms-flex-positive: 0;
          flex-grow: 0;
  -webkit-flex-shrink: 1;
      -ms-flex-negative: 1;
          flex-shrink: 1;
}
.mdl-demo section .section__text {
  -webkit-flex-grow: 1;
      -ms-flex-positive: 1;
          flex-grow: 1;
  -webkit-flex-shrink: 0;
      -ms-flex-negative: 0;
          flex-shrink: 0;
  padding-top: 8px;
}
.mdl-demo section .section__text h5 {
  font-size: inherit;
  margin: 0;
  margin-bottom: 0.5em;
}
.mdl-demo section .section__text a {
  text-decoration: none;
}
.mdl-demo section .section__circle-container > .section__circle-container__circle {
  width: 64px;
  height: 64px;
  border-radius: 32px;
  margin: 8px 0;
}
.mdl-demo section.section--footer .section__circle--big {
  width: 100px;
  height: 100px;
  border-radius: 50px;
  margin: 8px 32px;
}
.mdl-demo .is-small-screen section.section--footer .section__circle--big {
  width: 50px;
  height: 50px;
  border-radius: 25px;
  margin: 8px 16px;
}
.mdl-demo section.section--footer {
  padding: 64px 0;
  margin: 75px -8px -8px -8px; /*Customized for formbuilder*/
}
.mdl-demo section.section--center .section__text:not(:last-child) {
  border-bottom: 1px solid rgba(0,0,0,.13);
}
.mdl-demo .mdl-card .mdl-card__supporting-text > h3:first-child {
  margin-bottom: 24px;
}
.mdl-demo .mdl-layout__tab-panel:not(#overview) {
  background-color: white;
}
.mdl-demo #features section {
  margin-bottom: 72px;
}
.mdl-demo #features h4, #features h5 {
  margin-bottom: 16px;
}
.mdl-demo .toc {
  border-left: 4px solid #C1EEF4;
  margin: 24px;
  padding: 0;
  padding-left: 8px;
  display: -webkit-flex;
  display: -ms-flexbox;
  display: flex;
  -webkit-flex-direction: column;
      -ms-flex-direction: column;
          flex-direction: column;
}
.mdl-demo .toc h4 {
  font-size: 0.9rem;
  margin-top: 0;
}
.mdl-demo .toc a {
  color: #4DD0E1;
  text-decoration: none;
  font-size: 16px;
  line-height: 28px;
  display: block;
}
.mdl-demo .mdl-menu__container {
  z-index: 99;
}

/* CUSTOMIZATION FOR FORMBUILDER */
#floating-button-addQuestion {
  position: fixed;
  display: block;
  right: 0;
  bottom: 0;
  margin-right: 5%;
  /*margin-bottom: 200px;*/
  margin-bottom: 360px;
  z-index: 900;
}
#floating-button-addTitleDescription {
  position: fixed;
  display: block;
  right: 0;
  bottom: 0;
  margin-right: 5%;
  margin-bottom: 290px;
  z-index: 900;
}
#floating-button-addPage {
  position: fixed;
  display: block;
  right: 0;
  bottom: 0;
  margin-right: 5%;
  margin-bottom: 220px;
  z-index: 900;
}
#floating-button-saveForm {
  position: fixed;
  display: block;
  right: 0;
  bottom: 0;
  margin-right: 5%;
  margin-bottom: 150px;
  z-index: 900;
}
.floating-button:hover {
  background-color:#9C27B0 !important;
}
.item-description {
  /*margin-bottom: 0.5em;*/
  /*padding: 10px 0;*/
  /*margin-top: 0em;*/
  width: 90%;
}
.item-description-text {
  font-size: 14px;
}

/*.disable {
  float: right;
}

.icon-delete {
  float: right;
  margin-right: 10px;
}*/

.icon-align {
  /*font-size: 30px;*/
  display: inline-flex;
  vertical-align: middle;
}

/*.checkbox-req, .checkbox-disable {
  width: 100px;
}*/
/*.disable {
  
}*/
.mdl-switch__label {
  font-size: 14px;
}

.switch-required {
  width: 125px;
}

.checkbox-disable {
  width: 100px;
  margin-left: 24px
}

.footer-separator {
  border-left: 1px solid #e0e0e0;
  height: 32px;
  margin: 0 16px;
  width: 0
}

.preview-text {
  color: rgba(0, 0, 0, .25);
  border-bottom: 1px dotted rgba(0, 0, 0, .12);
  width: 50%;
  margin: 18px 0px 0px 10px;
}
.menu-item {
  padding: 0px 20px 0px 20px;
}
.menu-text {
  float: right;
  width: 140px;
}

.menu-scroll {
  overflow: scroll;
  width: 225px;
  height: 200px;
}

.cancela,.cancela:link,.cancela:visited,.cancela:active {
  color: inherit;
  text-decoration: none;
  margin: 25px 0px 0px 0px;
  /*margin-left: 15px;*/
}
.cancela:hover,.cancela:focus {
  color: rgb(117, 117, 117);
}

    </style>
  </head>
  <body class="mdl-demo mdl-color--grey-100 mdl-color-text--grey-700 mdl-base">
    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
      <header class="mdl-layout__header mdl-layout__header--scroll mdl-color--primary">
        <div class="mdl-layout--large-screen-only mdl-layout__header-row">
        </div>
        <div class="mdl-layout--large-screen-only mdl-layout__header-row">
          <h3>Formbuilder</h3>
        </div>
        <div class="mdl-layout--large-screen-only mdl-layout__header-row">
        </div>
        <div class="mdl-layout__tab-bar mdl-js-ripple-effect mdl-color--primary-dark">
          <a href="#" class="mdl-layout__tab is-active">Home</a>
          <a href="#" class="mdl-layout__tab">Forms</a>
          <a href="#" class="mdl-layout__tab">Download</a>
          <a href="#" class="mdl-layout__tab">Account</a>
          <a href="#" class="mdl-layout__tab">FAQ</a>
          <!-- Add spacer, to align navigation to the right -->
          <div class="mdl-layout-spacer"></div>
          <!-- <a class="mdl-navigation__link" href="">Login</a> -->
          <a href="#" class="mdl-layout__tab"><i class="icon-align material-icons">account_circle</i> LOGIN TO MY ACCOUNT</a>
        </div>
      </header>
      <main class="mdl-layout__content">
        <div class="mdl-layout__tab-panel is-active" id="overview">

          <!-- FORM TITLE, DESCRIPTION, TOGGLE AVAILABLE, DELETE FORM -->
          <section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--2dp">
            <div class="mdl-card mdl-cell mdl-cell--12-col">
              <div class="mdl-card__supporting-text">
                <form action="#">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                      <input class="mdl-textfield__input" type="text" id="formTitle"/>
                      <label class="mdl-textfield__label" for="formTitle">Form Title</label>
                    </div>
                    <br>
                    <div class="item-description mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                      <input class="mdl-textfield__input" type="text" id="formDescription"/>
                      <label class="item-description-text mdl-textfield__label" for="formDescription">Form Description</label>
                    </div>  
              </div>
            </div>
            <!-- <div class="mdl-card__actions"></div> -->
            </form>
              <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="btn0">
                <i class="material-icons">more_vert</i>
              </button>
              <ul class="mdl-menu mdl-js-menu mdl-menu--bottom-right" for="btn0">
                <li class="mdl-menu__item"><i class="icon-align material-icons">block</i> Disable this form</li>
                <li class="mdl-menu__item"><i class="icon-align material-icons">delete_sweep</i> Delete this form</li>
              </ul>    
          </section>

          <!-- EMPTY TEMPLATE -->
          <section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--2dp">
            <div class="mdl-card mdl-cell mdl-cell--12-col">
                <div class="mdl-card__supporting-text">
                  <form action="#">
                    <div class="item-description mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                      <input class="mdl-textfield__input" type="text" id="textTitle"/>
                      <label class="mdl-textfield__label" for="textTitle">Question</label>
                    </div>
                    <br>
                    <div class="item-description mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                      <textarea class="mdl-textfield__input" type="text" rows= "2" id="textareaDescription" ></textarea>
                      <label class="item-description-text mdl-textfield__label" for="textareaDescription">Description</label>
                    </div>
                  </form>
                  <!-- ### JQUERY ACTIONS HERE ### -->
                  <div class="jquery-itemType"></div>
                </div>
              <!-- Footer: Required/Disable/Delete actions -->
              <div class="mdl-card__actions">
                <label class="switch-required mdl-switch mdl-js-switch" for="switch-1">
                  <input type="checkbox" id="switch-1" class="mdl-switch__input">
                  <span class="mdl-switch__label">Required</span>
                </label>
                <span class="footer-separator"></span>
                
                  <label class="checkbox-disable checkbox-req mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="checkbox-disable1">
                    <input type="checkbox" id="checkbox-disable1" class="mdl-checkbox__input">
                    <span class="mdl-checkbox__label"><p>Disable</p></span>
                  </label>
                  <a href="#" class="cancela"><i class="icon-align material-icons icon-delete" id="icon-delete-tooltip1">delete</i></a>
                  <div class="mdl-tooltip mdl-tooltip--right" data-mdl-for="icon-delete-tooltip1">Delete this question</div>
              </div>

            </div>
            <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="btn1">
              <i class="material-icons">more_vert</i>
            </button>
            <ul class="menu-scroll mdl-menu mdl-js-menu mdl-menu--bottom-right" for="btn1">
              <li class="jquery-shortText mdl-menu__item"><i class="icon-align menu-icon material-icons">short_text</i><span class="menu-text">Short answer</span></li>
              <li class="jquery-paragraph mdl-menu__item"><i class="icon-align material-icons">wrap_text</i><span class="menu-text">Paragraph</span></li>
              <li class="jquery-multipleChoice mdl-menu__item"><i class="icon-align material-icons">radio_button_checked</i><span class="menu-text">Multiple choice</span></li>
              <li class="jquery-checkbox mdl-menu__item"><i class="icon-align material-icons">check_box</i><span class="menu-text">Checkboxes</span></li>
              <li class="jquery-dropdown mdl-menu__item"><i class="icon-align material-icons">arrow_drop_down_circle</i><span class="menu-text">Dropdown</span></li>
              <li class="jquery-date mdl-menu__item"><i class="icon-align material-icons">date_range</i><span class="menu-text">Date</span></li>
              <li class="jquery-time mdl-menu__item"><i class="icon-align material-icons">access_time</i><span class="menu-text">Time</span></li>
            </ul>
          </section>

          <!-- ITEMTEXT -->
          <section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--2dp">
            <div class="mdl-card mdl-cell mdl-cell--12-col">
                <div class="mdl-card__supporting-text">

                  <form action="#">
                    <div class="item-description text-box mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                      <input class="mdl-textfield__input" type="text" id="textItemTitle"/>
                      <label class="mdl-textfield__label" for="textItemTitle">Question</label>
                    </div>
                    <br>
                    <div class="item-description mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                      <textarea class="mdl-textfield__input" type="text" rows= "2" id="textItemDescription" ></textarea>
                      <label class="item-description-text mdl-textfield__label" for="textItemDescription">Description</label>
                    </div>
                  </form>
                  <p class="preview-text">Short answer text.</p>
                </div>
              <!-- Footer: Required/Disable/Delete actions -->
              <div class="mdl-card__actions">
                <label class="switch-required mdl-switch mdl-js-switch" for="switch-2">
                  <input type="checkbox" id="switch-2" class="mdl-switch__input">
                  <span class="mdl-switch__label">Required</span>
                </label>
                <span class="footer-separator"></span>
                
                  <label class="checkbox-disable checkbox-req mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="checkbox-disable2">
                    <input type="checkbox" id="checkbox-disable2" class="mdl-checkbox__input">
                    <span class="mdl-checkbox__label"><p>Disable</p></span>
                  </label>
                  <a href="#" class="cancela"><i class="icon-align material-icons icon-delete" id="icon-delete-tooltip2">delete</i></a>
                  <div class="mdl-tooltip mdl-tooltip--right" data-mdl-for="icon-delete-tooltip2">Delete this question</div>
              </div>
            </div>
            <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="btn2">
              <i class="material-icons">more_vert</i>
            </button>
            <ul class="menu-scroll mdl-menu mdl-js-menu mdl-menu--bottom-right" for="btn2">
              <li class="mdl-menu__item"><i class="icon-align menu-icon material-icons">short_text</i> Short answer</li>
              <li class="mdl-menu__item"><i class="icon-align material-icons">wrap_text</i> Paragraph</li>
              <li class="mdl-menu__item"><i class="icon-align material-icons">radio_button_checked</i> Multiple choice</li>
              <li class="mdl-menu__item"><i class="icon-align material-icons">check_box</i> Checkboxes</li>
              <li class="mdl-menu__item"><i class="icon-align material-icons">arrow_drop_down_circle</i> Dropdown</li>
              <li class="mdl-menu__item"><i class="icon-align material-icons">date_range</i> Date</li>
              <li class="mdl-menu__item"><i class="icon-align material-icons">access_time</i> Time</li>
            </ul>
          </section>

          <!-- CHECKBOX -->
          <section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--2dp">
            <div class="mdl-card mdl-cell mdl-cell--12-col">
                <div class="mdl-card__supporting-text">
                  <form action="#">
                    <div class="item-description text-box mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                      <input class="mdl-textfield__input" type="text" id="checkboxItemTitle"/>
                      <label class="mdl-textfield__label" for="checkboxItemTitle">Question</label>
                    </div>
                    <br>
                    <div class="item-description mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                      <textarea class="mdl-textfield__input" type="text" rows= "2" id="checkboxItemDescription" ></textarea>
                      <label class="item-description-text mdl-textfield__label" for="checkboxItemDescription">Description</label>
                    </div>
                  </form>
                  <div class="preview-text">
                    <i class="icon-align material-icons">check_box_outline_blank</i>
                    <div class="mdl-textfield mdl-js-textfield">
                      <input class="mdl-textfield__input" type="text" id="checkbox1">
                      <label class="mdl-textfield__label" for="checkbox1"> . . . enter checkbox choice</label>
                    </div>
                    <br><br>
                    <a href="#" class="cancela"><i class="icon-align material-icons">add_circle_outline</i> Add another choice.</a>
                  </div>
                </div>
              <!-- Footer: Required/Disable/Delete actions -->
              <div class="mdl-card__actions">
                <label class="switch-required mdl-switch mdl-js-switch" for="switch-3">
                  <input type="checkbox" id="switch-3" class="mdl-switch__input">
                  <span class="mdl-switch__label">Required</span>
                </label>
                <span class="footer-separator"></span>
                
                  <label class="checkbox-disable checkbox-req mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="checkbox-disable3">
                    <input type="checkbox" id="checkbox-disable3" class="mdl-checkbox__input">
                    <span class="mdl-checkbox__label"><p>Disable</p></span>
                  </label>
                  <a href="#" class="cancela"><i class="icon-align material-icons icon-delete" id="icon-delete-tooltip3">delete</i></a>
                  <div class="mdl-tooltip mdl-tooltip--right" data-mdl-for="icon-delete-tooltip3">Delete this question</div>
              </div>
            </div>
            <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="btn3">
              <i class="material-icons">more_vert</i>
            </button>
            <ul class="menu-scroll mdl-menu mdl-js-menu mdl-menu--bottom-right" for="btn3">
              <li class="mdl-menu__item"><i class="icon-align menu-icon material-icons">short_text</i> Short answer</li>
              <li class="mdl-menu__item"><i class="icon-align material-icons">wrap_text</i> Paragraph</li>
              <li class="mdl-menu__item"><i class="icon-align material-icons">radio_button_checked</i> Multiple choice</li>
              <li class="mdl-menu__item"><i class="icon-align material-icons">check_box</i> Checkboxes</li>
              <li class="mdl-menu__item"><i class="icon-align material-icons">arrow_drop_down_circle</i> Dropdown</li>
              <li class="mdl-menu__item"><i class="icon-align material-icons">date_range</i> Date</li>
              <li class="mdl-menu__item"><i class="icon-align material-icons">access_time</i> Time</li>
            </ul>
          </section>

          <!-- SECTION HEADER AND DESCRIPTION -->
<!--           <section class="section--center mdl-grid mdl-grid--no-spacing mdl-shadow--2dp">
            <div class="mdl-card mdl-cell mdl-cell--12-col">
              <div class="mdl-card__supporting-text">
                <h4>Section Header</h4>
                <p>Section description</p>
              </div>
              <div class="mdl-card__actions">
                <a href="#" class="mdl-button">Empty Link</a>
              </div>
            </div>
            
          </section> -->

          <section class="section--footer mdl-color--white mdl-grid">
            <div class="section__circle-container mdl-cell mdl-cell--2-col mdl-cell--1-col-phone"></div>
            <div class="section__text mdl-cell mdl-cell--4-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone"></div>
            <div class="section__circle-container mdl-cell mdl-cell--2-col mdl-cell--1-col-phone"></div>
            <div class="section__text mdl-cell mdl-cell--4-col-desktop mdl-cell--6-col-tablet mdl-cell--3-col-phone"></div>
          </section>

        </div>
        <footer class="mdl-mini-footer">
            <div class="mdl-mini-footer__left-section">
               <div class="mdl-logo">
                  Copyright Information
               </div>
               <ul class="mdl-mini-footer__link-list">
                  <li><a href="#">Help</a></li>
                  <li><a href="#">Privacy and Terms</a></li>
                  <li><a href="#">User Agreement</a></li>
               </ul>
            </div>
            <div class="mdl-mini-footer__right-section">
               <button class="mdl-mini-footer__social-btn">1</button>
               <button class="mdl-mini-footer__social-btn">2</button>
               <button class="mdl-mini-footer__social-btn">3</button>
            </div>
         </footer>
      </main>
    </div>
    <!-- <a href="#" id="floating-button-addQuestion" class="floating-button mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-color--accent mdl-color-text--accent-contrast"><i class="material-icons">add_circle</i></a>
    <a href="#" id="floating-button-addTitleDescription" class="floating-button mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-color--accent mdl-color-text--accent-contrast"><i class="material-icons">text_fields</i></a>
    <a href="#" id="floating-button-addPage" class="floating-button mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-color--accent mdl-color-text--accent-contrast"><i class="material-icons">library_books</i></a>
     -->
    <a href="#" id="floating-button-addQuestion" class="floating-button mdl-button mdl-js-button mdl-button--fab mdl-button--colored mdl-js-ripple-effect"><i class="material-icons">add</i></a>
    <a href="#" id="floating-button-addTitleDescription" class="floating-button mdl-button mdl-js-button mdl-button--fab mdl-button--colored mdl-js-ripple-effect"><i class="material-icons">text_fields</i></a>
    <a href="#" id="floating-button-addPage" class="floating-button mdl-button mdl-js-button mdl-button--fab mdl-button--colored mdl-js-ripple-effect""><i class="material-icons">library_books</i></a>
    <a href="#" id="floating-button-saveForm" class="floating-button mdl-button mdl-js-button mdl-button--fab mdl-button--colored mdl-js-ripple-effect""><i class="material-icons">save</i></a>
    <div class="mdl-tooltip mdl-tooltip--left" data-mdl-for="floating-button-addQuestion">
      Add Question
    </div>
    <div class="mdl-tooltip mdl-tooltip--left" data-mdl-for="floating-button-addTitleDescription">
      Add Text-Only Section
    </div>
    <div class="mdl-tooltip mdl-tooltip--left" data-mdl-for="floating-button-addPage">
      Add Page
    </div>
    <div class="mdl-tooltip mdl-tooltip--left" data-mdl-for="floating-button-saveForm">
      Save this Form
    </div>

    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script>
      $( ".jquery-shortText" ).click(function() {
        $( ".jquery-itemType" ).html( "<div class=\"jquery-itemType\"><p class=\"preview-text\">Short answer text.</p></div>");
      });
      $( ".jquery-checkbox" ).click(function() {
        var checkboxHTML = `    
          <div class="preview-text">
            <i class="icon-align material-icons">check_box_outline_blank</i>
            <div class="mdl-textfield mdl-js-textfield">
              <input class="mdl-textfield__input" type="text" id="checkbox1">
              <label class="mdl-textfield__label" for="checkbox1"> . . . enter checkbox choice</label>
            </div>
            <br><br>
            <a href="#" class="cancela"><i class="icon-align material-icons">add_circle_outline</i> Add another choice.</a>
          </div>
        `;
        $( ".jquery-itemType" ).html( checkboxHTML );
        componentHandler.upgradeElement( $(".jquery-itemType") );
      });

    </script>
  </body>
</html>
