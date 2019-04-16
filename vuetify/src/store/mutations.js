// https://vuex.vuejs.org/en/mutations.html

export default {
  hideAll (state) {
    state.alert = false
    state.success = false
    state.message = null
    state.globalStatsVisible = false
    state.urlStatsVisible = false
    state.userRecordVisible = false
  },
  setGlobalStatsVisible (state, data) { state.globalStatsVisible = data },
  setUrlStatsVisible (state, data) { state.urlStatsVisible = data },
  setUserRecordVisible (state, data) { state.userRecordVisible = data },
  setAlert (state, data) { state.alert = data },
  setSuccess (state, data) { state.success = data },
  setMessage (state, data) { state.message = data },
  setStatsIdUser (state, data) { state.statsIdUser = data },
  setUsername (state, data) { state.username = data },
  setDeleteIdUser (state, data) { state.deleteIdUser = data },
  setStatsIdUrl (state, data) { state.statsIdUrl = data },
  setIdUserHyperlink (state, data) { state.idUserHyperlink = data },
  setHyperlink (state, data) { state.hyperlink = data },
  setDeleteIdUrl (state, data) { state.deleteIdUrl = data },
  setStatsDto (state, data) { state.statsDto = data },
  setUrlStatsDto (state, data) { state.urlStatsDto = data },
  setUserDto (state, data) { state.userDto = data }
}
