function convert(value) {
    switch (value) {
        case 0:
            return 0
        case 1:
            return 1
        default:
            return convert(Math.floor(value/2)) + (value%2).toString()
    }
}

document.getElementById("input").addEventListener("change", (e) => {
    document.getElementById("output").innerHTML = convert(parseInt(e.currentTarget.value))
})