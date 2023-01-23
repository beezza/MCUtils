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

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

object PlayerManager {

    fun getPlayerByName(playerName: String): Player? {
        return Bukkit.getPlayer(playerName)
    }

    fun tpTo(player: Player, location: Location) {
        player.teleport(location)
    }

    fun <T: JavaPlugin>saveInventory(player: Player, instance: T) {
        val f = File(instance.dataFolder.absolutePath, "/inventory/" + player.name + ".yml")
        val c = YamlConfiguration.loadConfiguration(f)
        c.set("inventory.armor", player.inventory.armorContents)
        c.set("inventory.content", player.inventory.contents)
        c.save(f)
    }


    fun <T: JavaPlugin>loadInventory(player: Player, instance: T) {
        val f = File(instance.dataFolder.absolutePath, "/inventory/" + player.name + ".yml")
        val c = YamlConfiguration.loadConfiguration(f)
        var content = (c["inventory.armor"] as List<ItemStack>).toTypedArray()
        player.inventory.setArmorContents(content)
        content = (c["inventory.content"] as List<ItemStack>).toTypedArray()
        player.inventory.contents = content

    }

}
