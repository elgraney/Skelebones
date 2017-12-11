/**
 * Created by Matthew on 10/12/2017.
 */

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class ReasonableDrops {

    public ItemStack getFullItem() {
        Material itemType = getItem();
        ItemStack newItem = new ItemStack(itemType, 1);
        ArrayList<Enchantment> enchants = new ArrayList<Enchantment>();

        if (itemType == Material.DIAMOND_SWORD || itemType == Material.IRON_SWORD || itemType == Material.GOLD_SWORD) {

            enchants = new ArrayList<Enchantment>(Arrays.asList(Enchantment.DAMAGE_ALL, Enchantment.DAMAGE_ARTHROPODS,
                    Enchantment.DAMAGE_UNDEAD, Enchantment.FIRE_ASPECT));

            ItemMeta itemMeta = newItem.getItemMeta();
            newItem.setItemMeta(swordLore(itemMeta));
        }

        else if(itemType == Material.DIAMOND_AXE || itemType == Material.IRON_AXE || itemType == Material.GOLD_AXE){

            enchants = new ArrayList<Enchantment>(Arrays.asList(Enchantment.DAMAGE_ALL, Enchantment.DAMAGE_ARTHROPODS,
                    Enchantment.DAMAGE_UNDEAD, Enchantment.DIG_SPEED, Enchantment.LOOT_BONUS_BLOCKS, Enchantment.MENDING,
                    Enchantment.SILK_TOUCH, Enchantment.DURABILITY));

            ItemMeta itemMeta = newItem.getItemMeta();
            newItem.setItemMeta(axeLore(itemMeta));
        }

        else if(itemType == Material.DIAMOND_PICKAXE || itemType == Material.IRON_PICKAXE || itemType == Material.GOLD_PICKAXE){

            enchants = new ArrayList<Enchantment>(Arrays.asList(Enchantment.DIG_SPEED, Enchantment.LOOT_BONUS_BLOCKS, Enchantment.MENDING,
                    Enchantment.SILK_TOUCH, Enchantment.DURABILITY));

            ItemMeta itemMeta = newItem.getItemMeta();
            newItem.setItemMeta(pickaxeLore(itemMeta));

        }
        else if(itemType == Material.DIAMOND_SPADE|| itemType == Material.IRON_SPADE || itemType == Material.GOLD_SPADE){

            enchants = new ArrayList<Enchantment>(Arrays.asList(Enchantment.DIG_SPEED, Enchantment.LUCK, Enchantment.MENDING,
                    Enchantment.SILK_TOUCH, Enchantment.DURABILITY));

            ItemMeta itemMeta = newItem.getItemMeta();
            newItem.setItemMeta(spadeLore(itemMeta));
        }

        else if(itemType == Material.DIAMOND_HOE|| itemType == Material.IRON_HOE|| itemType == Material.GOLD_HOE){

            enchants = new ArrayList<Enchantment>(Arrays.asList(Enchantment.MENDING, Enchantment.DURABILITY));

            ItemMeta itemMeta = newItem.getItemMeta();
            newItem.setItemMeta(hoeLore(itemMeta));

        }
        newItem = addEnchant(newItem, enchants);
        return newItem;

    }


    private Material getItem()
    {
        Material[] itemTypes = {Material.DIAMOND_SWORD, Material.IRON_SWORD, Material.GOLD_SWORD,
                Material.DIAMOND_AXE,Material.IRON_AXE,  Material.GOLD_AXE,
                Material.DIAMOND_PICKAXE,Material.IRON_PICKAXE,  Material.GOLD_PICKAXE,
                Material.DIAMOND_SPADE,Material.IRON_SPADE,  Material.GOLD_SPADE,
                Material.DIAMOND_HOE,Material.IRON_HOE,  Material.GOLD_HOE,
                };


        Random rand = new Random();
        int  n = rand.nextInt(itemTypes.length-1) + 1;
        Material itemType = itemTypes[n];
        return itemType;
    }


    private ItemStack addEnchant(ItemStack item, ArrayList<Enchantment> enchants){

        Random rand = new Random();
        int  n = rand.nextInt(enchants.size()+1);

        System.out.println("Number of Enchants: "+n);
        for( int i = 0; i<= n; i++ ) {

            int index = rand.nextInt(enchants.size());
            item.addUnsafeEnchantment(enchants.get(index), rand.nextInt(5) + 1);
        }
        return item;
    }

    private ItemMeta swordLore(ItemMeta itemMeta){
        String[] noun = {"Saber", "Blade", "Needle", "Longsword", "Cleaver", "Sword", "Broadsword", "Rapier", "Scimitar",
                "Cutlas", "Dirk","Shortsword", "Katana"};

        int  n = getIndex(noun);

        String name = getAdjective() +" "+ noun[n];
        itemMeta.setDisplayName(name);

        //get lore
        return itemMeta;
    }

    private ItemMeta axeLore(ItemMeta itemMeta){
        String[] noun = {"Axe", "Blade", "Chopper", "Handaxe", "Greataxe", "Hatchet", "Cleaver", "Tomahawk"};

        int  n = getIndex(noun);

        String name = getAdjective() +" "+ noun[n];
        itemMeta.setDisplayName(name);

        //get lore
        return itemMeta;
    }

    private ItemMeta pickaxeLore(ItemMeta itemMeta){
        String[] noun = {"Pickaxe", "Mattock", "Hack", "Pick", "Pickax"};

        int  n = getIndex(noun);

        String name = getAdjective()+" " + noun[n];
        itemMeta.setDisplayName(name);

        //get lore
        return itemMeta;
    }
    private ItemMeta spadeLore(ItemMeta itemMeta){
        String[] noun = {"Spade", "Shovel", "Trowel", "Digger", "Scoop"};

        int  n = getIndex(noun);

        String name = getAdjective() +" "+ noun[n];
        itemMeta.setDisplayName(name);

        //get lore
        return itemMeta;
    }
    private ItemMeta hoeLore(ItemMeta itemMeta){

        String name = getAdjective() + " Hoe";
        itemMeta.setDisplayName(name);

        //get lore
        return itemMeta;
    }

    private  String getAdjective(){
        String[] adjective = {"Shining", "Refined", "Ancient", "Crafted", "Foiled", "Notched", "Weathered", "Weary",
                "Pointed", "Sacred", "Polished", "Hardened", "Reinforced", "Worn", "Dusty", "Weighted", "Old", "Forged",
                "Ornate", "Jeweled", "Bloody","Dented", "Sturdy", "Infused"};

        int n=getIndex(adjective);

        return adjective[n];
    }

    private int getIndex(String[] array){
        Random rand = new Random();
        int  n = rand.nextInt(array.length);
        return n;
    }
}
