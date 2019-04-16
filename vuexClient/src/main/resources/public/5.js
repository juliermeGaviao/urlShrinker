(this["webpackJsonp"] = this["webpackJsonp"] || []).push([[5],{

/***/ "./node_modules/cache-loader/dist/cjs.js?!./node_modules/babel-loader/lib/index.js!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader/lib/index.js?!./src/views/SinglePage.vue?vue&type=script&lang=js&":
/*!**************************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/cache-loader/dist/cjs.js??ref--12-0!./node_modules/babel-loader/lib!./node_modules/cache-loader/dist/cjs.js??ref--0-0!./node_modules/vue-loader/lib??vue-loader-options!./src/views/SinglePage.vue?vue&type=script&lang=js& ***!
  \**************************************************************************************************************************************************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var C_dev_urlShrinker_workspace_urlShrinker_vuetify_node_modules_babel_runtime_corejs2_helpers_esm_objectSpread__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime-corejs2/helpers/esm/objectSpread */ "./node_modules/@babel/runtime-corejs2/helpers/esm/objectSpread.js");
/* harmony import */ var vuex__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! vuex */ "./node_modules/vuex/dist/vuex.esm.js");

//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
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
  name: 'SinglePage',
  computed: Object(C_dev_urlShrinker_workspace_urlShrinker_vuetify_node_modules_babel_runtime_corejs2_helpers_esm_objectSpread__WEBPACK_IMPORTED_MODULE_0__["default"])({}, Object(vuex__WEBPACK_IMPORTED_MODULE_1__["mapState"])(['globalStatsVisible', 'urlStatsVisible', 'userRecordVisible', 'statsDto', 'urlStatsDto', 'userDto', 'headers']), {
    alert: {
      get: function get() {
        return this.$store.state.alert;
      },
      set: function set(value) {
        this.$store.commit('setAlert', value);
      }
    },
    success: {
      get: function get() {
        return this.$store.state.success;
      },
      set: function set(value) {
        this.$store.commit('setSuccess', value);
      }
    },
    message: {
      get: function get() {
        return this.$store.state.message;
      },
      set: function set(value) {
        this.$store.commit('setMessage', value);
      }
    },
    statsIdUser: {
      get: function get() {
        return this.$store.state.statsIdUser;
      },
      set: function set(value) {
        this.$store.commit('setStatsIdUser', value);
      }
    },
    statsIdUrl: {
      get: function get() {
        return this.$store.state.statsIdUrl;
      },
      set: function set(value) {
        this.$store.commit('setStatsIdUrl', value);
      }
    },
    username: {
      get: function get() {
        return this.$store.state.username;
      },
      set: function set(value) {
        this.$store.commit('setUsername', value);
      }
    },
    idUserHyperlink: {
      get: function get() {
        return this.$store.state.idUserHyperlink;
      },
      set: function set(value) {
        this.$store.commit('setIdUserHyperlink', value);
      }
    },
    hyperlink: {
      get: function get() {
        return this.$store.state.hyperlink;
      },
      set: function set(value) {
        this.$store.commit('setHyperlink', value);
      }
    },
    deleteIdUser: {
      get: function get() {
        return this.$store.state.deleteIdUser;
      },
      set: function set(value) {
        this.$store.commit('setDeleteIdUser', value);
      }
    },
    deleteIdUrl: {
      get: function get() {
        return this.$store.state.deleteIdUrl;
      },
      set: function set(value) {
        this.$store.commit('setDeleteIdUrl', value);
      }
    }
  }),
  methods: Object(C_dev_urlShrinker_workspace_urlShrinker_vuetify_node_modules_babel_runtime_corejs2_helpers_esm_objectSpread__WEBPACK_IMPORTED_MODULE_0__["default"])({
    vazio: function vazio(obj) {
      return obj === undefined || obj === null;
    },
    fetchUserStats: function fetchUserStats() {
      if (this.statsIdUser === null || isNaN(this.statsIdUser) || this.statsIdUser <= 0) {
        this.message = "Invalid User Id!";
        this.alert = true;
      } else {
        this.$store.dispatch('getUserStats');
      }
    },
    fetchUrlStats: function fetchUrlStats() {
      if (this.statsIdUrl === null || isNaN(this.statsIdUrl) || this.statsIdUrl <= 0) {
        this.message = "Invalid URL Id!";
        this.alert = true;
      } else {
        this.$store.dispatch('getUrlStats');
      }
    },
    insertUser: function insertUser() {
      if (this.username === null || this.username.length === 0) {
        this.message = "Invalid User Name!";
        this.alert = true;
      } else {
        this.$store.dispatch('addUser');
      }
    },
    insertUrl: function insertUrl() {
      if (this.idUserHyperlink === null || isNaN(this.idUserHyperlink) || this.idUserHyperlink <= 0) {
        this.message = "Invalid User Id!";
        this.alert = true;
      } else if (this.hyperlink === null || this.hyperlink.length === 0) {
        this.message = "Invalid Hyperlink!";
        this.alert = true;
      } else {
        this.$store.dispatch('addUrl');
      }
    },
    removeUser: function removeUser() {
      if (this.deleteIdUser === null || isNaN(this.deleteIdUser) || this.deleteIdUser <= 0) {
        this.message = "Invalid User Id!";
        this.alert = true;
      } else {
        this.$store.dispatch('deleteUser');
      }
    },
    removeUrl: function removeUrl() {
      if (this.deleteIdUrl === null || isNaN(this.deleteIdUrl) || this.deleteIdUrl <= 0) {
        this.message = "Invalid URL Id!";
        this.alert = true;
      } else {
        this.$store.dispatch('deleteUrl');
      }
    }
  }, Object(vuex__WEBPACK_IMPORTED_MODULE_1__["mapActions"])(['getGlobalStats', 'getUserStats', 'getUrlStats', 'addUser', 'addUrl', 'deleteUser', 'deleteUrl'])),
  created: function created() {
    this.getGlobalStats();
  }
});

/***/ }),

/***/ "./node_modules/cache-loader/dist/cjs.js?{\"cacheDirectory\":\"node_modules/.cache/vue-loader\",\"cacheIdentifier\":\"db59642c-vue-loader-template\"}!./node_modules/vue-loader/lib/loaders/templateLoader.js?!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader/lib/index.js?!./src/views/SinglePage.vue?vue&type=template&id=ef7c559e&":
/*!**********************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/cache-loader/dist/cjs.js?{"cacheDirectory":"node_modules/.cache/vue-loader","cacheIdentifier":"db59642c-vue-loader-template"}!./node_modules/vue-loader/lib/loaders/templateLoader.js??vue-loader-options!./node_modules/cache-loader/dist/cjs.js??ref--0-0!./node_modules/vue-loader/lib??vue-loader-options!./src/views/SinglePage.vue?vue&type=template&id=ef7c559e& ***!
  \**********************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************/
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
    [
      _c(
        "v-layout",
        { attrs: { row: "" } },
        [
          _c(
            "v-flex",
            { attrs: { xs12: "", "text-xs-center": "" } },
            [
              _c(
                "v-alert",
                {
                  attrs: { type: "warning", dismissible: "" },
                  model: {
                    value: _vm.alert,
                    callback: function($$v) {
                      _vm.alert = $$v
                    },
                    expression: "alert"
                  }
                },
                [_vm._v(_vm._s(_vm.message))]
              ),
              _c(
                "v-alert",
                {
                  attrs: { type: "success", dismissible: "" },
                  model: {
                    value: _vm.success,
                    callback: function($$v) {
                      _vm.success = $$v
                    },
                    expression: "success"
                  }
                },
                [_vm._v(_vm._s(_vm.message))]
              ),
              _c(
                "v-btn",
                {
                  attrs: { small: "", color: "info" },
                  on: { click: _vm.getGlobalStats }
                },
                [_vm._v("Get Global Statistics")]
              )
            ],
            1
          )
        ],
        1
      ),
      _c(
        "v-layout",
        { attrs: { row: "" } },
        [
          _c(
            "v-flex",
            { attrs: { xs3: "" } },
            [
              _c("v-text-field", {
                attrs: { placeholder: "User Id", type: "number" },
                model: {
                  value: _vm.statsIdUser,
                  callback: function($$v) {
                    _vm.statsIdUser = _vm._n($$v)
                  },
                  expression: "statsIdUser"
                }
              })
            ],
            1
          ),
          _c(
            "v-flex",
            { attrs: { xs3: "", "pt-2": "" } },
            [
              _c(
                "v-btn",
                {
                  attrs: { small: "", color: "info" },
                  on: { click: _vm.fetchUserStats }
                },
                [_vm._v("Get User Statistics")]
              )
            ],
            1
          ),
          _c(
            "v-flex",
            { attrs: { xs3: "" } },
            [
              _c("v-text-field", {
                attrs: { placeholder: "URL Id", type: "number" },
                model: {
                  value: _vm.statsIdUrl,
                  callback: function($$v) {
                    _vm.statsIdUrl = _vm._n($$v)
                  },
                  expression: "statsIdUrl"
                }
              })
            ],
            1
          ),
          _c(
            "v-flex",
            { attrs: { xs3: "", "pt-2": "" } },
            [
              _c(
                "v-btn",
                {
                  attrs: { small: "", color: "info" },
                  on: { click: _vm.fetchUrlStats }
                },
                [_vm._v("Get URL Statistics")]
              )
            ],
            1
          )
        ],
        1
      ),
      _c(
        "v-layout",
        { attrs: { row: "" } },
        [
          _c(
            "v-flex",
            { attrs: { xs3: "" } },
            [
              _c("v-text-field", {
                attrs: { placeholder: "User name" },
                model: {
                  value: _vm.username,
                  callback: function($$v) {
                    _vm.username = typeof $$v === "string" ? $$v.trim() : $$v
                  },
                  expression: "username"
                }
              })
            ],
            1
          ),
          _c(
            "v-flex",
            { attrs: { xs3: "", "pt-2": "" } },
            [
              _c(
                "v-btn",
                {
                  attrs: { small: "", color: "info" },
                  on: { click: _vm.insertUser }
                },
                [_vm._v("Add User")]
              )
            ],
            1
          ),
          _c(
            "v-flex",
            { attrs: { xs2: "" } },
            [
              _c("v-text-field", {
                attrs: { placeholder: "User Id", type: "number" },
                model: {
                  value: _vm.idUserHyperlink,
                  callback: function($$v) {
                    _vm.idUserHyperlink = _vm._n($$v)
                  },
                  expression: "idUserHyperlink"
                }
              })
            ],
            1
          ),
          _c(
            "v-flex",
            { attrs: { xs2: "" } },
            [
              _c("v-text-field", {
                attrs: { placeholder: "Hperlink" },
                model: {
                  value: _vm.hyperlink,
                  callback: function($$v) {
                    _vm.hyperlink = typeof $$v === "string" ? $$v.trim() : $$v
                  },
                  expression: "hyperlink"
                }
              })
            ],
            1
          ),
          _c(
            "v-flex",
            { attrs: { xs2: "", "pt-2": "" } },
            [
              _c(
                "v-btn",
                {
                  attrs: { small: "", color: "info" },
                  on: { click: _vm.insertUrl }
                },
                [_vm._v("Add URL")]
              )
            ],
            1
          )
        ],
        1
      ),
      _c(
        "v-layout",
        { attrs: { row: "" } },
        [
          _c(
            "v-flex",
            { attrs: { xs3: "" } },
            [
              _c("v-text-field", {
                attrs: { placeholder: "User Id", type: "number" },
                model: {
                  value: _vm.deleteIdUser,
                  callback: function($$v) {
                    _vm.deleteIdUser = _vm._n($$v)
                  },
                  expression: "deleteIdUser"
                }
              })
            ],
            1
          ),
          _c(
            "v-flex",
            { attrs: { xs3: "", "pt-2": "" } },
            [
              _c(
                "v-btn",
                {
                  attrs: { small: "", color: "info" },
                  on: { click: _vm.removeUser }
                },
                [_vm._v("Delete User")]
              )
            ],
            1
          ),
          _c(
            "v-flex",
            { attrs: { xs3: "" } },
            [
              _c("v-text-field", {
                attrs: { placeholder: "URL Id", type: "number" },
                model: {
                  value: _vm.deleteIdUrl,
                  callback: function($$v) {
                    _vm.deleteIdUrl = _vm._n($$v)
                  },
                  expression: "deleteIdUrl"
                }
              })
            ],
            1
          ),
          _c(
            "v-flex",
            { attrs: { xs3: "", "pt-2": "" } },
            [
              _c(
                "v-btn",
                {
                  attrs: { small: "", color: "info" },
                  on: { click: _vm.removeUrl }
                },
                [_vm._v("Delete URL")]
              )
            ],
            1
          )
        ],
        1
      ),
      _c(
        "v-layout",
        {
          directives: [
            {
              name: "show",
              rawName: "v-show",
              value: _vm.globalStatsVisible,
              expression: "globalStatsVisible"
            }
          ],
          attrs: { row: "" }
        },
        [
          _c("v-flex", { attrs: { xs6: "" } }, [
            _vm._v("Hits: " + _vm._s(_vm.statsDto.hits))
          ]),
          _c("v-flex", { attrs: { xs6: "" } }, [
            _vm._v("URL Count: " + _vm._s(_vm.statsDto.urlCount))
          ])
        ],
        1
      ),
      _c(
        "v-layout",
        {
          directives: [
            {
              name: "show",
              rawName: "v-show",
              value: _vm.urlStatsVisible,
              expression: "urlStatsVisible"
            }
          ],
          attrs: { row: "" }
        },
        [
          _c("v-data-table", {
            staticStyle: { width: "100%" },
            attrs: { headers: _vm.headers, items: _vm.urlStatsDto },
            scopedSlots: _vm._u([
              {
                key: "items",
                fn: function(urls) {
                  return [
                    _c("td", [_vm._v(_vm._s(urls.item.id))]),
                    _c("td", [_vm._v(_vm._s(urls.item.hits))]),
                    _c("td", [_vm._v(_vm._s(urls.item.url))]),
                    _c("td", [_vm._v(_vm._s(urls.item.shortUrl))])
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
  )
}
var staticRenderFns = []
render._withStripped = true



/***/ }),

/***/ "./src/views/SinglePage.vue":
/*!**********************************!*\
  !*** ./src/views/SinglePage.vue ***!
  \**********************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _SinglePage_vue_vue_type_template_id_ef7c559e___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./SinglePage.vue?vue&type=template&id=ef7c559e& */ "./src/views/SinglePage.vue?vue&type=template&id=ef7c559e&");
/* harmony import */ var _SinglePage_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./SinglePage.vue?vue&type=script&lang=js& */ "./src/views/SinglePage.vue?vue&type=script&lang=js&");
/* empty/unused harmony star reexport *//* harmony import */ var _node_modules_vue_loader_lib_runtime_componentNormalizer_js__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../node_modules/vue-loader/lib/runtime/componentNormalizer.js */ "./node_modules/vue-loader/lib/runtime/componentNormalizer.js");





/* normalize component */

var component = Object(_node_modules_vue_loader_lib_runtime_componentNormalizer_js__WEBPACK_IMPORTED_MODULE_2__["default"])(
  _SinglePage_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__["default"],
  _SinglePage_vue_vue_type_template_id_ef7c559e___WEBPACK_IMPORTED_MODULE_0__["render"],
  _SinglePage_vue_vue_type_template_id_ef7c559e___WEBPACK_IMPORTED_MODULE_0__["staticRenderFns"],
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
      api.createRecord('ef7c559e', component.options)
    } else {
      api.reload('ef7c559e', component.options)
    }
    module.hot.accept(/*! ./SinglePage.vue?vue&type=template&id=ef7c559e& */ "./src/views/SinglePage.vue?vue&type=template&id=ef7c559e&", function(__WEBPACK_OUTDATED_DEPENDENCIES__) { /* harmony import */ _SinglePage_vue_vue_type_template_id_ef7c559e___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./SinglePage.vue?vue&type=template&id=ef7c559e& */ "./src/views/SinglePage.vue?vue&type=template&id=ef7c559e&");
(function () {
      api.rerender('ef7c559e', {
        render: _SinglePage_vue_vue_type_template_id_ef7c559e___WEBPACK_IMPORTED_MODULE_0__["render"],
        staticRenderFns: _SinglePage_vue_vue_type_template_id_ef7c559e___WEBPACK_IMPORTED_MODULE_0__["staticRenderFns"]
      })
    })(__WEBPACK_OUTDATED_DEPENDENCIES__); })
  }
}
component.options.__file = "src/views/SinglePage.vue"
/* harmony default export */ __webpack_exports__["default"] = (component.exports);

/***/ }),

/***/ "./src/views/SinglePage.vue?vue&type=script&lang=js&":
/*!***********************************************************!*\
  !*** ./src/views/SinglePage.vue?vue&type=script&lang=js& ***!
  \***********************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _node_modules_cache_loader_dist_cjs_js_ref_12_0_node_modules_babel_loader_lib_index_js_node_modules_cache_loader_dist_cjs_js_ref_0_0_node_modules_vue_loader_lib_index_js_vue_loader_options_SinglePage_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!../../node_modules/cache-loader/dist/cjs.js??ref--12-0!../../node_modules/babel-loader/lib!../../node_modules/cache-loader/dist/cjs.js??ref--0-0!../../node_modules/vue-loader/lib??vue-loader-options!./SinglePage.vue?vue&type=script&lang=js& */ "./node_modules/cache-loader/dist/cjs.js?!./node_modules/babel-loader/lib/index.js!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader/lib/index.js?!./src/views/SinglePage.vue?vue&type=script&lang=js&");
/* empty/unused harmony star reexport */ /* harmony default export */ __webpack_exports__["default"] = (_node_modules_cache_loader_dist_cjs_js_ref_12_0_node_modules_babel_loader_lib_index_js_node_modules_cache_loader_dist_cjs_js_ref_0_0_node_modules_vue_loader_lib_index_js_vue_loader_options_SinglePage_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__["default"]); 

/***/ }),

/***/ "./src/views/SinglePage.vue?vue&type=template&id=ef7c559e&":
/*!*****************************************************************!*\
  !*** ./src/views/SinglePage.vue?vue&type=template&id=ef7c559e& ***!
  \*****************************************************************/
/*! exports provided: render, staticRenderFns */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _cache_loader_cacheDirectory_node_modules_cache_vue_loader_cacheIdentifier_db59642c_vue_loader_template_node_modules_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_node_modules_cache_loader_dist_cjs_js_ref_0_0_node_modules_vue_loader_lib_index_js_vue_loader_options_SinglePage_vue_vue_type_template_id_ef7c559e___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!cache-loader?{"cacheDirectory":"node_modules/.cache/vue-loader","cacheIdentifier":"db59642c-vue-loader-template"}!../../node_modules/vue-loader/lib/loaders/templateLoader.js??vue-loader-options!../../node_modules/cache-loader/dist/cjs.js??ref--0-0!../../node_modules/vue-loader/lib??vue-loader-options!./SinglePage.vue?vue&type=template&id=ef7c559e& */ "./node_modules/cache-loader/dist/cjs.js?{\"cacheDirectory\":\"node_modules/.cache/vue-loader\",\"cacheIdentifier\":\"db59642c-vue-loader-template\"}!./node_modules/vue-loader/lib/loaders/templateLoader.js?!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader/lib/index.js?!./src/views/SinglePage.vue?vue&type=template&id=ef7c559e&");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "render", function() { return _cache_loader_cacheDirectory_node_modules_cache_vue_loader_cacheIdentifier_db59642c_vue_loader_template_node_modules_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_node_modules_cache_loader_dist_cjs_js_ref_0_0_node_modules_vue_loader_lib_index_js_vue_loader_options_SinglePage_vue_vue_type_template_id_ef7c559e___WEBPACK_IMPORTED_MODULE_0__["render"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "staticRenderFns", function() { return _cache_loader_cacheDirectory_node_modules_cache_vue_loader_cacheIdentifier_db59642c_vue_loader_template_node_modules_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_node_modules_cache_loader_dist_cjs_js_ref_0_0_node_modules_vue_loader_lib_index_js_vue_loader_options_SinglePage_vue_vue_type_template_id_ef7c559e___WEBPACK_IMPORTED_MODULE_0__["staticRenderFns"]; });



/***/ })

}]);
//# sourceMappingURL=5.js.map