function search_component(format) {
    axios.get(`${protocol}//${hostname}:${port}/v1/search/${format}/component?keyword=${keyword}`)
            .then(() => console.log("hi"));
}