// https://vuex.vuejs.org/en/state.html

export default {
  urlServer: '/urlShrinkerVuex',
  globalStatsVisible: false,
  urlStatsVisible: false,
  userRecordVisible: false,
  alert: false,
  success: false,
  message: null,
  statsIdUser: null,
  username: null,
  deleteIdUser: null,
  statsIdUrl: null,
  idUserHyperlink: null,
  hyperlink: null,
  deleteIdUrl: null,
  statsDto: {},
  urlStatsDto: [],
  userDto: {},
  headers: [
    { text: 'Id', value: 'id', sortable: true },
    { text: 'Hits', value: 'hits', sortable: true },
    { text: 'URL', value: 'url', sortable: true },
    { text: 'Short URL', value: 'shortUrl', sortable: true }
  ]
}
