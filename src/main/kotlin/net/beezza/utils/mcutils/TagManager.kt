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

object TagManager {

    fun exists(player: Player, tagName: String): Boolean {
        return player.scoreboardTags.contains(tagName)
    }

    fun add(player: Player, tagName: String) {
        player.scoreboardTags.add(tagName)
    }

    fun remove(player: Player, tagName: String) {
        player.scoreboardTags.remove(tagName)
    }
}
