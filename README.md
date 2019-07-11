# Organizacion-de-Eventos-NERON
autolinker:
    enable: true
    newWindow: true
    urls: true
    email: true
    tel: false
    twitter: false
    hashtag: instagram
    className: 'test'
```
#### Explanations:
Property | Default Value | Description
--- | --- | :--
`enable` | true | Enable the plugin
`newWindow` | true | Opens links in new tabs/windows <-> Add target="_blank"
`urls` | true | converts urls to links
`email` | true | converts email addresses to mailto links
`tel` | false | converts telephone numbers to tel links
`twitter` | false | converts twitter handles to links
`hastag` | false | Use `twitter`, `facebook` or `instagram` to convert hashtags to the links
`className` | false | Adds a custom class to the links that were transformed
Checkout [Autolinker.js](https://github.com/gregjacobs/Autolinker.js) and the [Autolinker live examples](http://gregjacobs.github.io/Autolinker.js/examples/live-example/) for more options and examples.
## License
MIT
