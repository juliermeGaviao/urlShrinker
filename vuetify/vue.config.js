module.exports = {
  devServer: {
    disableHostCheck: true,
    proxy: {
      '/': {
        target: 'http://localhost:5050',
        ws: false
      }
    }
  },
  configureWebpack: {
    devtool: 'source-map'
  },
  publicPath: '/urlShrinkerVuex'
}
