module.exports = {
  "transpileDependencies": [
    "vuetify"
  ]
}

module.exports = {
  devServer: {
    port:8081,
    proxy: 'http://127.0.0.1:8080'
  }
};