package de.immernochnoah.golf.manager;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemManager {

	private ItemStack itemStack;
	private List<String> lore;
	private ItemMeta meta;

	public ItemManager(final ItemStack item) {
		this.lore = new ArrayList<String>();
		this.itemStack = item;
		this.meta = item.getItemMeta();
	}

	public ItemManager(final Material mat) {
		this.lore = new ArrayList<String>();
		this.itemStack = new ItemStack(mat, 1, (short) 0);
		this.meta = this.itemStack.getItemMeta();
	}

	public ItemManager setAmount(final int value) {
		this.itemStack.setAmount(value);
		return this;
	}

	public ItemManager setNoName() {
		this.meta.setDisplayName(" ");
		return this;
	}

	public ItemManager setGlow() {
		this.meta.addEnchant(Enchantment.DURABILITY, 1, true);
		this.meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		return this;
	}

	public ItemManager setData(final short data) {
		this.itemStack.setDurability(data);
		return this;
	}

	public ItemManager addLoreLine(final String line) {
		this.lore.add(line);
		return this;
	}

	public ItemManager setDisplayName(final String name) {
		this.meta.setDisplayName(name);
		return this;
	}

	public ItemManager setSkullOwner(final String owner) {
		((SkullMeta) this.meta).setOwner(owner);
		return this;
	}

	public ItemManager setColor(final Color c) {
		((LeatherArmorMeta) this.meta).setColor(c);
		return this;
	}

	public ItemManager addEnchantment(final Enchantment ench, final int lvl) {
		this.meta.addEnchant(ench, lvl, true);
		return this;
	}

	public ItemManager addLeatherColor(final Color color) {
		((LeatherArmorMeta) this.meta).setColor(color);
		return this;
	}

	public ItemManager setDurability(short durability) {
		itemStack.setDurability(durability);
		return this;
	}

	public ItemStack build() {
		if (!this.lore.isEmpty()) {
			this.meta.setLore(this.lore);
		}
		this.itemStack.setItemMeta(this.meta);
		return this.itemStack;
	}

	public static ItemStack createItem(Material material, int anzahl, int shortid, String DisplayName, String Lore, String lore2, String lore3) {
		ItemStack itemStack = new ItemStack(material, anzahl, (short) shortid);
		ItemMeta itemMeta = itemStack.getItemMeta();
		itemMeta.setDisplayName(DisplayName);
		itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
		itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
		itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_DESTROYS });
		if (Lore != null) {
			ArrayList<String> arrayList = new ArrayList<String>();
			arrayList.add(Lore);
			arrayList.add(lore2);
			arrayList.add(lore3);
			itemMeta.setLore(arrayList);
		}
		itemStack.setItemMeta(itemMeta);
		return itemStack;
	}
	public static ItemStack createItem(Material material, int anzahl, int shortid, String DisplayName, String Lore)
	{
		ItemStack i = new ItemStack(material, anzahl, (short)shortid);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(DisplayName);
		ArrayList<String> a = new ArrayList();
		a.add("");
		a.add(Lore);
		a.add("");
		im.setLore(a);
		im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
		im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
		im.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_DESTROYS });

		i.setItemMeta(im);
		return i;
	}

	public ItemManager addItemFlag(ItemFlag flag) {
		meta.addItemFlags(flag);
		return this;
	}
}
