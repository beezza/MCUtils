/*
 * Copyright (c) 2023 Beezza Networks
 *
 * You can use, modify, redistribute codes.
 *
 * You can use codes as commercial
 *
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package net.beezza.utils.mcutils

import org.bukkit.entity.Player

object ScoreManager {

    fun getScore(player: Player, scoreboardName: String): Int? {
        return player.scoreboard.getObjective(scoreboardName)?.getScore(player.name)?.score
    }

    fun addScore(player: Player, scoreboardName: String, value: Int): Boolean {
        val score = player.scoreboard.getObjective(scoreboardName)?.getScore(player.name)

        score?.score?.plus(value)

        return score != null
    }
    fun removeScore(player: Player, scoreboardName: String, value: Int): Boolean {
        val score = player.scoreboard.getObjective(scoreboardName)?.getScore(player.name)

        score?.score?.minus(value)

        return score != null
    }
    fun multiple(player: Player, scoreboardName: String, value: Int): Boolean {
        val score = player.scoreboard.getObjective(scoreboardName)?.getScore(player.name)

        score?.score?.times(value)

        return score != null
    }
    fun div(player: Player, scoreboardName: String, value: Int): Boolean {
        val score = player.scoreboard.getObjective(scoreboardName)?.getScore(player.name)

        score?.score?.div(value)

        return score != null
    }
}
