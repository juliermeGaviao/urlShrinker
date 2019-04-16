(this["webpackJsonp"] = this["webpackJsonp"] || []).push([[2],{

/***/ "./node_modules/cache-loader/dist/cjs.js?!./node_modules/babel-loader/lib/index.js!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader/lib/index.js?!./src/views/Dashboard.vue?vue&type=script&lang=js&":
/*!*************************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/cache-loader/dist/cjs.js??ref--12-0!./node_modules/babel-loader/lib!./node_modules/cache-loader/dist/cjs.js??ref--0-0!./node_modules/vue-loader/lib??vue-loader-options!./src/views/Dashboard.vue?vue&type=script&lang=js& ***!
  \*************************************************************************************************************************************************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
/* harmony default export */ __webpack_exports__["default"] = ({
  data: function data() {
    return {
      dailySalesChart: {
        data: {
          labels: ['M', 'T', 'W', 'T', 'F', 'S', 'S'],
          series: [[12, 17, 7, 17, 23, 18, 38]]
        },
        options: {
          lineSmooth: this.$chartist.Interpolation.cardinal({
            tension: 0
          }),
          low: 0,
          high: 50,
          // creative tim: we recommend you to set the high sa the biggest value + something for a better look
          chartPadding: {
            top: 0,
            right: 0,
            bottom: 0,
            left: 0
          }
        }
      },
      dataCompletedTasksChart: {
        data: {
          labels: ['12am', '3pm', '6pm', '9pm', '12pm', '3am', '6am', '9am'],
          series: [[230, 750, 450, 300, 280, 240, 200, 190]]
        },
        options: {
          lineSmooth: this.$chartist.Interpolation.cardinal({
            tension: 0
          }),
          low: 0,
          high: 1000,
          // creative tim: we recommend you to set the high sa the biggest value + something for a better look
          chartPadding: {
            top: 0,
            right: 0,
            bottom: 0,
            left: 0
          }
        }
      },
      emailsSubscriptionChart: {
        data: {
          labels: ['Ja', 'Fe', 'Ma', 'Ap', 'Mai', 'Ju', 'Jul', 'Au', 'Se', 'Oc', 'No', 'De'],
          series: [[542, 443, 320, 780, 553, 453, 326, 434, 568, 610, 756, 895]]
        },
        options: {
          axisX: {
            showGrid: false
          },
          low: 0,
          high: 1000,
          chartPadding: {
            top: 0,
            right: 5,
            bottom: 0,
            left: 0
          }
        },
        responsiveOptions: [['screen and (max-width: 640px)', {
          seriesBarDistance: 5,
          axisX: {
            labelInterpolationFnc: function labelInterpolationFnc(value) {
              return value[0];
            }
          }
        }]]
      },
      headers: [{
        sortable: false,
        text: 'ID',
        value: 'id'
      }, {
        sortable: false,
        text: 'Name',
        value: 'name'
      }, {
        sortable: false,
        text: 'Salary',
        value: 'salary',
        align: 'right'
      }, {
        sortable: false,
        text: 'Country',
        value: 'country',
        align: 'right'
      }, {
        sortable: false,
        text: 'City',
        value: 'city',
        align: 'right'
      }],
      items: [{
        name: 'Dakota Rice',
        country: 'Niger',
        city: 'Oud-Tunrhout',
        salary: '$35,738'
      }, {
        name: 'Minerva Hooper',
        country: 'Curaçao',
        city: 'Sinaai-Waas',
        salary: '$23,738'
      }, {
        name: 'Sage Rodriguez',
        country: 'Netherlands',
        city: 'Overland Park',
        salary: '$56,142'
      }, {
        name: 'Philip Chanley',
        country: 'Korea, South',
        city: 'Gloucester',
        salary: '$38,735'
      }, {
        name: 'Doris Greene',
        country: 'Malawi',
        city: 'Feldkirchen in Kārnten',
        salary: '$63,542'
      }],
      tabs: 0,
      list: {
        0: false,
        1: false,
        2: false
      }
    };
  },
  methods: {
    complete: function complete(index) {
      this.list[index] = !this.list[index];
    }
  }
});

/***/ }),

/***/ "./node_modules/cache-loader/dist/cjs.js?{\"cacheDirectory\":\"node_modules/.cache/vue-loader\",\"cacheIdentifier\":\"db59642c-vue-loader-template\"}!./node_modules/vue-loader/lib/loaders/templateLoader.js?!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader/lib/index.js?!./src/views/Dashboard.vue?vue&type=template&id=22ba47ca&":
/*!*********************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/cache-loader/dist/cjs.js?{"cacheDirectory":"node_modules/.cache/vue-loader","cacheIdentifier":"db59642c-vue-loader-template"}!./node_modules/vue-loader/lib/loaders/templateLoader.js??vue-loader-options!./node_modules/cache-loader/dist/cjs.js??ref--0-0!./node_modules/vue-loader/lib??vue-loader-options!./src/views/Dashboard.vue?vue&type=template&id=22ba47ca& ***!
  \*********************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************/
/*! exports provided: render, staticRenderFns */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "render", function() { return render; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "staticRenderFns", function() { return staticRenderFns; });
var render = function() {
  var _vm = this
  var _h = _vm.$createElement
  var _c = _vm._self._c || _h
  return _c(
    "v-container",
    { attrs: { "fill-height": "", fluid: "", "grid-list-xl": "" } },
    [
      _c(
        "v-layout",
        { attrs: { wrap: "" } },
        [
          _c(
            "v-flex",
            { attrs: { md12: "", sm12: "", lg4: "" } },
            [
              _c(
                "material-chart-card",
                {
                  attrs: {
                    data: _vm.dailySalesChart.data,
                    options: _vm.dailySalesChart.options,
                    color: "info",
                    type: "Line"
                  }
                },
                [
                  _c("h4", { staticClass: "title font-weight-light" }, [
                    _vm._v("Daily Sales")
                  ]),
                  _c(
                    "p",
                    { staticClass: "category d-inline-flex font-weight-light" },
                    [
                      _c("v-icon", { attrs: { color: "green", small: "" } }, [
                        _vm._v("\n            mdi-arrow-up\n          ")
                      ]),
                      _c("span", { staticClass: "green--text" }, [
                        _vm._v("55%")
                      ]),
                      _vm._v(" \n          increase in today's sales\n        ")
                    ],
                    1
                  ),
                  _c(
                    "template",
                    { slot: "actions" },
                    [
                      _c(
                        "v-icon",
                        { staticClass: "mr-2", attrs: { small: "" } },
                        [_vm._v("\n            mdi-clock-outline\n          ")]
                      ),
                      _c(
                        "span",
                        { staticClass: "caption grey--text font-weight-light" },
                        [_vm._v("updated 4 minutes ago")]
                      )
                    ],
                    1
                  )
                ],
                2
              )
            ],
            1
          ),
          _c(
            "v-flex",
            { attrs: { md12: "", sm12: "", lg4: "" } },
            [
              _c(
                "material-chart-card",
                {
                  attrs: {
                    data: _vm.emailsSubscriptionChart.data,
                    options: _vm.emailsSubscriptionChart.options,
                    "responsive-options":
                      _vm.emailsSubscriptionChart.responsiveOptions,
                    color: "red",
                    type: "Bar"
                  }
                },
                [
                  _c("h4", { staticClass: "title font-weight-light" }, [
                    _vm._v("Email Subscription")
                  ]),
                  _c(
                    "p",
                    { staticClass: "category d-inline-flex font-weight-light" },
                    [_vm._v("Last Campaign Performance")]
                  ),
                  _c(
                    "template",
                    { slot: "actions" },
                    [
                      _c(
                        "v-icon",
                        { staticClass: "mr-2", attrs: { small: "" } },
                        [_vm._v("\n            mdi-clock-outline\n          ")]
                      ),
                      _c(
                        "span",
                        { staticClass: "caption grey--text font-weight-light" },
                        [_vm._v("updated 10 minutes ago")]
                      )
                    ],
                    1
                  )
                ],
                2
              )
            ],
            1
          ),
          _c(
            "v-flex",
            { attrs: { md12: "", sm12: "", lg4: "" } },
            [
              _c(
                "material-chart-card",
                {
                  attrs: {
                    data: _vm.dataCompletedTasksChart.data,
                    options: _vm.dataCompletedTasksChart.options,
                    color: "green",
                    type: "Line"
                  }
                },
                [
                  _c("h3", { staticClass: "title font-weight-light" }, [
                    _vm._v("Completed Tasks")
                  ]),
                  _c(
                    "p",
                    { staticClass: "category d-inline-flex font-weight-light" },
                    [_vm._v("Last Last Campaign Performance")]
                  ),
                  _c(
                    "template",
                    { slot: "actions" },
                    [
                      _c(
                        "v-icon",
                        { staticClass: "mr-2", attrs: { small: "" } },
                        [_vm._v("\n            mdi-clock-outline\n          ")]
                      ),
                      _c(
                        "span",
                        { staticClass: "caption grey--text font-weight-light" },
                        [_vm._v("campaign sent 26 minutes ago")]
                      )
                    ],
                    1
                  )
                ],
                2
              )
            ],
            1
          ),
          _c(
            "v-flex",
            { attrs: { sm6: "", xs12: "", md6: "", lg3: "" } },
            [
              _c("material-stats-card", {
                attrs: {
                  color: "green",
                  icon: "mdi-store",
                  title: "Revenue",
                  value: "$34,245",
                  "sub-icon": "mdi-calendar",
                  "sub-text": "Last 24 Hours"
                }
              })
            ],
            1
          ),
          _c(
            "v-flex",
            { attrs: { sm6: "", xs12: "", md6: "", lg3: "" } },
            [
              _c("material-stats-card", {
                attrs: {
                  color: "orange",
                  icon: "mdi-content-copy",
                  title: "Used Space",
                  value: "49/50",
                  "small-value": "GB",
                  "sub-icon": "mdi-alert",
                  "sub-icon-color": "error",
                  "sub-text": "Get More Space...",
                  "sub-text-color": "text-primary"
                }
              })
            ],
            1
          ),
          _c(
            "v-flex",
            { attrs: { sm6: "", xs12: "", md6: "", lg3: "" } },
            [
              _c("material-stats-card", {
                attrs: {
                  color: "red",
                  icon: "mdi-information-outline",
                  title: "Fixed Issues",
                  value: "75",
                  "sub-icon": "mdi-tag",
                  "sub-text": "Tracked from Github"
                }
              })
            ],
            1
          ),
          _c(
            "v-flex",
            { attrs: { sm6: "", xs12: "", md6: "", lg3: "" } },
            [
              _c("material-stats-card", {
                attrs: {
                  color: "info",
                  icon: "mdi-twitter",
                  title: "Followers",
                  value: "+245",
                  "sub-icon": "mdi-update",
                  "sub-text": "Just Updated"
                }
              })
            ],
            1
          ),
          _c(
            "v-flex",
            { attrs: { md12: "", lg6: "" } },
            [
              _c(
                "material-card",
                {
                  attrs: {
                    color: "orange",
                    title: "Employee Stats",
                    text: "New employees on 15th September, 2016"
                  }
                },
                [
                  _c("v-data-table", {
                    attrs: {
                      headers: _vm.headers,
                      items: _vm.items,
                      "hide-actions": ""
                    },
                    scopedSlots: _vm._u([
                      {
                        key: "headerCell",
                        fn: function(ref) {
                          var header = ref.header
                          return [
                            _c("span", {
                              staticClass:
                                "font-weight-light text-warning text--darken-3",
                              domProps: { textContent: _vm._s(header.text) }
                            })
                          ]
                        }
                      },
                      {
                        key: "items",
                        fn: function(ref) {
                          var index = ref.index
                          var item = ref.item
                          return [
                            _c("td", [_vm._v(_vm._s(index + 1))]),
                            _c("td", [_vm._v(_vm._s(item.name))]),
                            _c("td", { staticClass: "text-xs-right" }, [
                              _vm._v(_vm._s(item.salary))
                            ]),
                            _c("td", { staticClass: "text-xs-right" }, [
                              _vm._v(_vm._s(item.country))
                            ]),
                            _c("td", { staticClass: "text-xs-right" }, [
                              _vm._v(_vm._s(item.city))
                            ])
                          ]
                        }
                      }
                    ])
                  })
                ],
                1
              )
            ],
            1
          ),
          _c(
            "v-flex",
            { attrs: { md12: "", lg6: "" } },
            [
              _c(
                "material-card",
                { staticClass: "card-tabs", attrs: { color: "green" } },
                [
                  _c(
                    "v-flex",
                    { attrs: { slot: "header" }, slot: "header" },
                    [
                      _c(
                        "v-tabs",
                        {
                          attrs: {
                            color: "transparent",
                            "slider-color": "white"
                          },
                          model: {
                            value: _vm.tabs,
                            callback: function($$v) {
                              _vm.tabs = $$v
                            },
                            expression: "tabs"
                          }
                        },
                        [
                          _c(
                            "span",
                            {
                              staticClass: "subheading font-weight-light mr-3",
                              staticStyle: { "align-self": "center" }
                            },
                            [_vm._v("Tasks:")]
                          ),
                          _c(
                            "v-tab",
                            { staticClass: "mr-3" },
                            [
                              _c("v-icon", { staticClass: "mr-2" }, [
                                _vm._v("mdi-bug")
                              ]),
                              _vm._v("\n              Bugs\n            ")
                            ],
                            1
                          ),
                          _c(
                            "v-tab",
                            { staticClass: "mr-3" },
                            [
                              _c("v-icon", { staticClass: "mr-2" }, [
                                _vm._v("mdi-code-tags")
                              ]),
                              _vm._v("\n              Website\n            ")
                            ],
                            1
                          ),
                          _c(
                            "v-tab",
                            [
                              _c("v-icon", { staticClass: "mr-2" }, [
                                _vm._v("mdi-cloud")
                              ]),
                              _vm._v("\n              Server\n            ")
                            ],
                            1
                          )
                        ],
                        1
                      )
                    ],
                    1
                  ),
                  _c(
                    "v-tabs-items",
                    {
                      model: {
                        value: _vm.tabs,
                        callback: function($$v) {
                          _vm.tabs = $$v
                        },
                        expression: "tabs"
                      }
                    },
                    _vm._l(3, function(n) {
                      return _c(
                        "v-tab-item",
                        { key: n },
                        [
                          _c(
                            "v-list",
                            { attrs: { "three-line": "" } },
                            [
                              _c(
                                "v-list-tile",
                                {
                                  on: {
                                    click: function($event) {
                                      return _vm.complete(0)
                                    }
                                  }
                                },
                                [
                                  _c(
                                    "v-list-tile-action",
                                    [
                                      _c("v-checkbox", {
                                        attrs: {
                                          value: _vm.list[0],
                                          color: "green"
                                        }
                                      })
                                    ],
                                    1
                                  ),
                                  _c("v-list-tile-title", [
                                    _vm._v(
                                      '\n                  Sign contract for "What are conference organized afraid of?"\n                '
                                    )
                                  ]),
                                  _c(
                                    "div",
                                    { staticClass: "d-flex" },
                                    [
                                      _c(
                                        "v-tooltip",
                                        {
                                          attrs: {
                                            top: "",
                                            "content-class": "top"
                                          }
                                        },
                                        [
                                          _c(
                                            "v-btn",
                                            {
                                              staticClass: "v-btn--simple",
                                              attrs: {
                                                slot: "activator",
                                                color: "success",
                                                icon: ""
                                              },
                                              slot: "activator"
                                            },
                                            [
                                              _c(
                                                "v-icon",
                                                { attrs: { color: "primary" } },
                                                [_vm._v("mdi-pencil")]
                                              )
                                            ],
                                            1
                                          ),
                                          _c("span", [_vm._v("Edit")])
                                        ],
                                        1
                                      ),
                                      _c(
                                        "v-tooltip",
                                        {
                                          attrs: {
                                            top: "",
                                            "content-class": "top"
                                          }
                                        },
                                        [
                                          _c(
                                            "v-btn",
                                            {
                                              staticClass: "v-btn--simple",
                                              attrs: {
                                                slot: "activator",
                                                color: "danger",
                                                icon: ""
                                              },
                                              slot: "activator"
                                            },
                                            [
                                              _c(
                                                "v-icon",
                                                { attrs: { color: "error" } },
                                                [_vm._v("mdi-close")]
                                              )
                                            ],
                                            1
                                          ),
                                          _c("span", [_vm._v("Close")])
                                        ],
                                        1
                                      )
                                    ],
                                    1
                                  )
                                ],
                                1
                              ),
                              _c("v-divider"),
                              _c(
                                "v-list-tile",
                                {
                                  on: {
                                    click: function($event) {
                                      return _vm.complete(1)
                                    }
                                  }
                                },
                                [
                                  _c(
                                    "v-list-tile-action",
                                    [
                                      _c("v-checkbox", {
                                        attrs: {
                                          value: _vm.list[1],
                                          color: "success"
                                        }
                                      })
                                    ],
                                    1
                                  ),
                                  _c("v-list-tile-title", [
                                    _vm._v(
                                      "\n                  Lines From Great Russian Literature? Or E-mails From My Boss?\n                "
                                    )
                                  ]),
                                  _c(
                                    "div",
                                    { staticClass: "d-flex" },
                                    [
                                      _c(
                                        "v-tooltip",
                                        {
                                          attrs: {
                                            top: "",
                                            "content-class": "top"
                                          }
                                        },
                                        [
                                          _c(
                                            "v-btn",
                                            {
                                              staticClass: "v-btn--simple",
                                              attrs: {
                                                slot: "activator",
                                                color: "success",
                                                icon: ""
                                              },
                                              slot: "activator"
                                            },
                                            [
                                              _c(
                                                "v-icon",
                                                { attrs: { color: "primary" } },
                                                [_vm._v("mdi-pencil")]
                                              )
                                            ],
                                            1
                                          ),
                                          _c("span", [_vm._v("Edit")])
                                        ],
                                        1
                                      ),
                                      _c(
                                        "v-tooltip",
                                        {
                                          attrs: {
                                            top: "",
                                            "content-class": "top"
                                          }
                                        },
                                        [
                                          _c(
                                            "v-btn",
                                            {
                                              staticClass: "v-btn--simple",
                                              attrs: {
                                                slot: "activator",
                                                color: "danger",
                                                icon: ""
                                              },
                                              slot: "activator"
                                            },
                                            [
                                              _c(
                                                "v-icon",
                                                { attrs: { color: "error" } },
                                                [_vm._v("mdi-close")]
                                              )
                                            ],
                                            1
                                          ),
                                          _c("span", [_vm._v("Close")])
                                        ],
                                        1
                                      )
                                    ],
                                    1
                                  )
                                ],
                                1
                              ),
                              _c("v-divider"),
                              _c(
                                "v-list-tile",
                                {
                                  on: {
                                    click: function($event) {
                                      return _vm.complete(2)
                                    }
                                  }
                                },
                                [
                                  _c(
                                    "v-list-tile-action",
                                    [
                                      _c("v-checkbox", {
                                        attrs: {
                                          value: _vm.list[2],
                                          color: "success"
                                        }
                                      })
                                    ],
                                    1
                                  ),
                                  _c("v-list-tile-title", [
                                    _vm._v(
                                      "\n                  Flooded: One year later, assessing what was lost and what was found when a ravaging rain swept through metro Detroit\n                "
                                    )
                                  ]),
                                  _c(
                                    "div",
                                    { staticClass: "d-flex" },
                                    [
                                      _c(
                                        "v-tooltip",
                                        {
                                          attrs: {
                                            top: "",
                                            "content-class": "top"
                                          }
                                        },
                                        [
                                          _c(
                                            "v-btn",
                                            {
                                              staticClass: "v-btn--simple",
                                              attrs: {
                                                slot: "activator",
                                                color: "success",
                                                icon: ""
                                              },
                                              slot: "activator"
                                            },
                                            [
                                              _c(
                                                "v-icon",
                                                { attrs: { color: "primary" } },
                                                [_vm._v("mdi-pencil")]
                                              )
                                            ],
                                            1
                                          ),
                                          _c("span", [_vm._v("Edit")])
                                        ],
                                        1
                                      ),
                                      _c(
                                        "v-tooltip",
                                        {
                                          attrs: {
                                            top: "",
                                            "content-class": "top"
                                          }
                                        },
                                        [
                                          _c(
                                            "v-btn",
                                            {
                                              staticClass: "v-btn--simple",
                                              attrs: {
                                                slot: "activator",
                                                color: "danger",
                                                icon: ""
                                              },
                                              slot: "activator"
                                            },
                                            [
                                              _c(
                                                "v-icon",
                                                { attrs: { color: "error" } },
                                                [_vm._v("mdi-close")]
                                              )
                                            ],
                                            1
                                          ),
                                          _c("span", [_vm._v("Close")])
                                        ],
                                        1
                                      )
                                    ],
                                    1
                                  )
                                ],
                                1
                              )
                            ],
                            1
                          )
                        ],
                        1
                      )
                    }),
                    1
                  )
                ],
                1
              )
            ],
            1
          )
        ],
        1
      )
    ],
    1
  )
}
var staticRenderFns = []
render._withStripped = true



/***/ }),

/***/ "./src/views/Dashboard.vue":
/*!*********************************!*\
  !*** ./src/views/Dashboard.vue ***!
  \*********************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _Dashboard_vue_vue_type_template_id_22ba47ca___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./Dashboard.vue?vue&type=template&id=22ba47ca& */ "./src/views/Dashboard.vue?vue&type=template&id=22ba47ca&");
/* harmony import */ var _Dashboard_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./Dashboard.vue?vue&type=script&lang=js& */ "./src/views/Dashboard.vue?vue&type=script&lang=js&");
/* empty/unused harmony star reexport *//* harmony import */ var _node_modules_vue_loader_lib_runtime_componentNormalizer_js__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../node_modules/vue-loader/lib/runtime/componentNormalizer.js */ "./node_modules/vue-loader/lib/runtime/componentNormalizer.js");





/* normalize component */

var component = Object(_node_modules_vue_loader_lib_runtime_componentNormalizer_js__WEBPACK_IMPORTED_MODULE_2__["default"])(
  _Dashboard_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__["default"],
  _Dashboard_vue_vue_type_template_id_22ba47ca___WEBPACK_IMPORTED_MODULE_0__["render"],
  _Dashboard_vue_vue_type_template_id_22ba47ca___WEBPACK_IMPORTED_MODULE_0__["staticRenderFns"],
  false,
  null,
  null,
  null
  
)

/* hot reload */
if (true) {
  var api = __webpack_require__(/*! ./node_modules/vue-hot-reload-api/dist/index.js */ "./node_modules/vue-hot-reload-api/dist/index.js")
  api.install(__webpack_require__(/*! vue */ "./node_modules/vue/dist/vue.runtime.esm.js"))
  if (api.compatible) {
    module.hot.accept()
    if (!module.hot.data) {
      api.createRecord('22ba47ca', component.options)
    } else {
      api.reload('22ba47ca', component.options)
    }
    module.hot.accept(/*! ./Dashboard.vue?vue&type=template&id=22ba47ca& */ "./src/views/Dashboard.vue?vue&type=template&id=22ba47ca&", function(__WEBPACK_OUTDATED_DEPENDENCIES__) { /* harmony import */ _Dashboard_vue_vue_type_template_id_22ba47ca___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./Dashboard.vue?vue&type=template&id=22ba47ca& */ "./src/views/Dashboard.vue?vue&type=template&id=22ba47ca&");
(function () {
      api.rerender('22ba47ca', {
        render: _Dashboard_vue_vue_type_template_id_22ba47ca___WEBPACK_IMPORTED_MODULE_0__["render"],
        staticRenderFns: _Dashboard_vue_vue_type_template_id_22ba47ca___WEBPACK_IMPORTED_MODULE_0__["staticRenderFns"]
      })
    })(__WEBPACK_OUTDATED_DEPENDENCIES__); })
  }
}
component.options.__file = "src/views/Dashboard.vue"
/* harmony default export */ __webpack_exports__["default"] = (component.exports);

/***/ }),

/***/ "./src/views/Dashboard.vue?vue&type=script&lang=js&":
/*!**********************************************************!*\
  !*** ./src/views/Dashboard.vue?vue&type=script&lang=js& ***!
  \**********************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _node_modules_cache_loader_dist_cjs_js_ref_12_0_node_modules_babel_loader_lib_index_js_node_modules_cache_loader_dist_cjs_js_ref_0_0_node_modules_vue_loader_lib_index_js_vue_loader_options_Dashboard_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!../../node_modules/cache-loader/dist/cjs.js??ref--12-0!../../node_modules/babel-loader/lib!../../node_modules/cache-loader/dist/cjs.js??ref--0-0!../../node_modules/vue-loader/lib??vue-loader-options!./Dashboard.vue?vue&type=script&lang=js& */ "./node_modules/cache-loader/dist/cjs.js?!./node_modules/babel-loader/lib/index.js!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader/lib/index.js?!./src/views/Dashboard.vue?vue&type=script&lang=js&");
/* empty/unused harmony star reexport */ /* harmony default export */ __webpack_exports__["default"] = (_node_modules_cache_loader_dist_cjs_js_ref_12_0_node_modules_babel_loader_lib_index_js_node_modules_cache_loader_dist_cjs_js_ref_0_0_node_modules_vue_loader_lib_index_js_vue_loader_options_Dashboard_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__["default"]); 

/***/ }),

/***/ "./src/views/Dashboard.vue?vue&type=template&id=22ba47ca&":
/*!****************************************************************!*\
  !*** ./src/views/Dashboard.vue?vue&type=template&id=22ba47ca& ***!
  \****************************************************************/
/*! exports provided: render, staticRenderFns */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _cache_loader_cacheDirectory_node_modules_cache_vue_loader_cacheIdentifier_db59642c_vue_loader_template_node_modules_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_node_modules_cache_loader_dist_cjs_js_ref_0_0_node_modules_vue_loader_lib_index_js_vue_loader_options_Dashboard_vue_vue_type_template_id_22ba47ca___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!cache-loader?{"cacheDirectory":"node_modules/.cache/vue-loader","cacheIdentifier":"db59642c-vue-loader-template"}!../../node_modules/vue-loader/lib/loaders/templateLoader.js??vue-loader-options!../../node_modules/cache-loader/dist/cjs.js??ref--0-0!../../node_modules/vue-loader/lib??vue-loader-options!./Dashboard.vue?vue&type=template&id=22ba47ca& */ "./node_modules/cache-loader/dist/cjs.js?{\"cacheDirectory\":\"node_modules/.cache/vue-loader\",\"cacheIdentifier\":\"db59642c-vue-loader-template\"}!./node_modules/vue-loader/lib/loaders/templateLoader.js?!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader/lib/index.js?!./src/views/Dashboard.vue?vue&type=template&id=22ba47ca&");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "render", function() { return _cache_loader_cacheDirectory_node_modules_cache_vue_loader_cacheIdentifier_db59642c_vue_loader_template_node_modules_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_node_modules_cache_loader_dist_cjs_js_ref_0_0_node_modules_vue_loader_lib_index_js_vue_loader_options_Dashboard_vue_vue_type_template_id_22ba47ca___WEBPACK_IMPORTED_MODULE_0__["render"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "staticRenderFns", function() { return _cache_loader_cacheDirectory_node_modules_cache_vue_loader_cacheIdentifier_db59642c_vue_loader_template_node_modules_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_node_modules_cache_loader_dist_cjs_js_ref_0_0_node_modules_vue_loader_lib_index_js_vue_loader_options_Dashboard_vue_vue_type_template_id_22ba47ca___WEBPACK_IMPORTED_MODULE_0__["staticRenderFns"]; });



/***/ })

}]);
//# sourceMappingURL=2.js.map