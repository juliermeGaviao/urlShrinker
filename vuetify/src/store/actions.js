// https://vuex.vuejs.org/en/actions.html
import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.use(Vuex)
Vue.use(VueAxios, axios)

export default {
  getGlobalStats: function ({ commit, state }) {
    commit('hideAll')

    Vue.axios.get(state.urlServer + '/globalStats').then(response => {
      commit('setStatsDto', response.data)
      commit('setGlobalStatsVisible', true)

      commit('setUrlStatsDto', response.data.topUrls)
      commit('setUrlStatsVisible', true)
    })
  },

  getUserStats: function ({ commit, state }) {
    commit('hideAll')

    Vue.axios.get(state.urlServer + '/userStats/' + state.statsIdUser).then(response => {
      commit('setUrlStatsVisible', response.data.length > 0)

      if (state.urlStatsVisible) {
        commit('setUrlStatsDto', response.data)
      } else {
        commit('setUrlStatsDto', [])
      }
    }).catch(error => console.log(error))
  },

  getUrlStats: function ({ commit, state }) {
    commit('hideAll')

    Vue.axios.get(state.urlServer + '/urlStats/' + state.statsIdUrl).then(response => {
      commit('setUrlStatsVisible', response.data.id != null)

      if (state.urlStatsVisible) {
        commit('setUrlStatsDto', [response.data])
      } else {
        commit('setUrlStatsDto', [])
      }
    }).catch(error => console.log(error))
  },

  addUser: function ({ commit, state }) {
    commit('hideAll')

    var userDto = { 'userName': state.username }

    Vue.axios.post(state.urlServer + '/addUser', userDto).then(response => {
      if (response.status === 201) {
        commit('setUserDto', response.data)
        commit('setUserRecordVisible', true)
        commit('setMessage', 'User [' + state.username + '] added successfully!')
        commit('setSuccess', true)
      } else if (response.status === 204) {
        commit('setMessage', 'The user [username=' + state.username + '] already exists!')
        commit('setAlert', true)
      }
    }).catch(error => console.log(error))
  },

  addUrl: function ({ commit, state }) {
    commit('hideAll')

    var urlDto = { 'url': state.hyperlink }

    Vue.axios.post(state.urlServer + '/addUrl/' + state.idUserHyperlink, urlDto).then(response => {
      if (response.status === 201) {
        commit('setUrlStatsVisible', response.data.length > 0)

        if (state.urlStatsVisible) {
          commit('setUrlStatsDto', response.data)
        } else {
          commit('setUrlStatsDto', [])
        }

        commit('setMessage', 'URL [' + state.hyperlink + '] added successfully!')
        commit('setSuccess', true)
      } else if (response.status === 204) {
        commit('setMessage', 'The user [id=' + state.idUserHyperlink + '] has not been found!')
        commit('setAlert', true)
      }
    }).catch(error => console.log(error))
  },

  deleteUser: function ({ commit, state }) {
    commit('hideAll')

    Vue.axios.delete(state.urlServer + '/deleteUser/' + state.deleteIdUser).then(response => {
      if (response.status === 200) {
        commit('setMessage', response.data)
        commit('setSuccess', true)
      } else if (response.status === 204) {
        commit('setMessage', "User Id hasn't been found!")
        commit('setAlert', true)
      }
    }).catch(error => console.log(error))
  },

  deleteUrl: function ({ commit, state }) {
    commit('hideAll')

    Vue.axios.delete(state.urlServer + '/deleteUrl/' + state.deleteIdUrl).then(response => {
      if (response.status === 200) {
        commit('setMessage', response.data)
        commit('setSuccess', true)
      } else if (response.status === 204) {
        commit('setMessage', "URL Id hasn't been found!")
        commit('setAlert', true)
      }
    }).catch(error => console.log(error))
  }
}
