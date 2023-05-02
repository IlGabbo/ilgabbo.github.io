function minimax(cell, is_maximizing) {
    let status = checkVictory(cell)
    let best_move = -1
    if (status != 0) {
        if (status == 1) {
            console.log(1)
        } else if (status == 2) {
            console.log(2)
        } else {
            console.log(0, -1)
        }
    }

    let best_score
    let max
    if (is_maximizing) {
        best_score = -Infinity
        max = false
    } else {
        best_score = Infinity
        max = true
    }

    for (let i = 0; i < cell.length; i++) {
        for (let o = 0; o < cell[i].length; o++) {
            if (cell[i][o] == null) {
                cell[i][o] = 1
                let score = minimax(cell, max)
                cell[i][o] = null
            }
        }
    }

    
}


