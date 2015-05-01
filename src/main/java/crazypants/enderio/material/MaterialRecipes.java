package crazypants.enderio.material;

import java.util.ArrayList;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.enderio.core.common.util.OreDictionaryHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import crazypants.enderio.EnderIO;
import crazypants.enderio.config.Config;
import crazypants.enderio.machine.obelisk.weather.TileWeatherObelisk.WeatherTask;

import static com.enderio.core.common.util.OreDictionaryHelper.*;
import static crazypants.enderio.EnderIO.itemBasicCapacitor;

public class MaterialRecipes {

  public static void registerDependantOresInDictionary() {
    if (hasCopper()) {
      OreDictionary.registerOre("dustCopper", new ItemStack(EnderIO.itemPowderIngot, 1, PowderIngot.POWDER_COPPER.ordinal()));
    }
    if (hasTin()) {
      OreDictionary.registerOre("dustTin", new ItemStack(EnderIO.itemPowderIngot, 1, PowderIngot.POWDER_TIN.ordinal()));
    }
    if (hasEnderPearlDust()) {
      OreDictionary.registerOre("dustEnderPearl", new ItemStack(EnderIO.itemPowderIngot, 1, PowderIngot.POWDER_ENDER.ordinal()));
    }
    //Enderium Base
    if (OreDictionaryHelper.hasEnderium()) {
      OreDictionary.registerOre("ingotEnderiumBase", new ItemStack(EnderIO.itemPowderIngot, 1, PowderIngot.INGOT_ENDERIUM_BASE.ordinal()));
    }
  }

  public static void registerOresInDictionary() {
    //Ore Dictionary Registeration
    OreDictionary.registerOre("dustCoal", new ItemStack(EnderIO.itemPowderIngot, 1, PowderIngot.POWDER_COAL.ordinal()));
    OreDictionary.registerOre("dustIron", new ItemStack(EnderIO.itemPowderIngot, 1, PowderIngot.POWDER_IRON.ordinal()));
    OreDictionary.registerOre("dustGold", new ItemStack(EnderIO.itemPowderIngot, 1, PowderIngot.POWDER_GOLD.ordinal()));
    OreDictionary.registerOre("dustObsidian", new ItemStack(EnderIO.itemPowderIngot, 1, PowderIngot.POWDER_OBSIDIAN.ordinal()));

    OreDictionary.registerOre("gearStone", new ItemStack(EnderIO.itemMachinePart, 1, MachinePart.BASIC_GEAR.ordinal()));
    OreDictionary.registerOre("itemSilicon", new ItemStack(EnderIO.itemMaterial, 1, Material.SILICON.ordinal()));

    for (Alloy alloy : Alloy.values()) {
      OreDictionary.registerOre(alloy.oredictIngotName, new ItemStack(EnderIO.itemAlloy, 1, alloy.ordinal()));
      OreDictionary.registerOre(alloy.oredictBlockName, new ItemStack(EnderIO.blockIngotStorage, 1, alloy.ordinal()));
    }

    OreDictionary.registerOre("nuggetPulsatingIron", new ItemStack(EnderIO.itemMaterial, 1, Material.PHASED_IRON_NUGGET.ordinal()));
    OreDictionary.registerOre("nuggetVibrantAlloy", new ItemStack(EnderIO.itemMaterial, 1, Material.VIBRANT_NUGGET.ordinal()));

    OreDictionary.registerOre("glass", Blocks.glass);
    OreDictionary.registerOre("stickWood", Items.stick);
    OreDictionary.registerOre("woodStick", Items.stick);
    OreDictionary.registerOre("sand", new ItemStack(Blocks.sand, 1, OreDictionary.WILDCARD_VALUE));
    OreDictionary.registerOre("ingotIron", Items.iron_ingot);
    OreDictionary.registerOre("ingotGold", Items.gold_ingot);

    ItemStack pureGlass = new ItemStack(EnderIO.blockFusedQuartz, 1, BlockFusedQuartz.Type.GLASS.ordinal());
    OreDictionary.registerOre("glass", pureGlass);
    OreDictionary.registerOre("blockGlass", pureGlass);
    OreDictionary.registerOre("blockGlassHardened", new ItemStack(EnderIO.blockFusedQuartz, 1, BlockFusedQuartz.Type.FUSED_QUARTZ.ordinal()));

    //Skulls
    ItemStack skull = new ItemStack(Items.skull, 1, OreDictionary.WILDCARD_VALUE);
    OreDictionary.registerOre("itemSkull", skull);
    OreDictionary.registerOre("itemSkull", new ItemStack(EnderIO.blockEndermanSkull));

    //Glass stuff for compatability
    GameRegistry.addShapedRecipe(new ItemStack(Blocks.glass_pane, 16, 0), "   ", "eee", "eee", 'e', pureGlass);
    GameRegistry.addShapelessRecipe(new ItemStack(Blocks.glass), pureGlass);
    GameRegistry.addShapedRecipe(new ItemStack(Items.glass_bottle, 3, 0), "   ", "g g", " g ", 'g', pureGlass);

    Material.registerOres(EnderIO.itemMaterial);
  }

  public static void addRecipes() {

    //Common Ingredients
    ItemStack conduitBinder = new ItemStack(EnderIO.itemMaterial, 4, Material.CONDUIT_BINDER.ordinal());
    ItemStack basicGear = new ItemStack(EnderIO.itemMachinePart, 1, MachinePart.BASIC_GEAR.ordinal());
    ItemStack binderComposite = new ItemStack(EnderIO.itemMaterial, 1, Material.BINDER_COMPOSITE.ordinal());

    ItemStack fusedQuartzFrame = new ItemStack(EnderIO.itemFusedQuartzFrame, 1, 0);
    ItemStack machineChassi = new ItemStack(EnderIO.itemMachinePart, 1, MachinePart.MACHINE_CHASSI.ordinal());

    ItemStack phasedGold = new ItemStack(EnderIO.itemAlloy, 1, Alloy.PHASED_GOLD.ordinal());
    ItemStack phasedIron = new ItemStack(EnderIO.itemAlloy, 1, Alloy.PHASED_IRON.ordinal());
    ItemStack electricalSteel = new ItemStack(EnderIO.itemAlloy, 1, Alloy.ELECTRICAL_STEEL.ordinal());
    ItemStack darkSteel = new ItemStack(EnderIO.itemAlloy, 1, Alloy.DARK_STEEL.ordinal());

    ItemStack capacitor = new ItemStack(itemBasicCapacitor, 1, 0);

    //Conduit Binder
    ItemStack cbc = binderComposite.copy();
    cbc.stackSize = 8;
    if (Config.useAlternateBinderRecipe) {
      GameRegistry.addShapedRecipe(cbc, "gcg", "sgs", "gcg", 'g', Blocks.gravel, 's', Blocks.sand, 'c', Items.clay_ball);
    } else {
      GameRegistry.addShapedRecipe(cbc, "ggg", "scs", "ggg", 'g', Blocks.gravel, 's', Blocks.sand, 'c', Items.clay_ball);
    }
    GameRegistry.addSmelting(binderComposite, conduitBinder, 0);

    //Nuggets
    ItemStack phasedIronNugget = new ItemStack(EnderIO.itemMaterial, 9, Material.PHASED_IRON_NUGGET.ordinal());
    GameRegistry.addShapelessRecipe(phasedIronNugget, phasedIron);
    phasedIronNugget = phasedIronNugget.copy();
    phasedIronNugget.stackSize = 1;
    GameRegistry.addShapedRecipe(phasedIron, "eee", "eee", "eee", 'e', phasedIronNugget);

    ItemStack vibrantNugget = new ItemStack(EnderIO.itemMaterial, 9, Material.VIBRANT_NUGGET.ordinal());
    GameRegistry.addShapelessRecipe(vibrantNugget, phasedGold);
    vibrantNugget = vibrantNugget.copy();
    vibrantNugget.stackSize = 1;
    GameRegistry.addShapedRecipe(phasedGold, "eee", "eee", "eee", 'e', vibrantNugget);

    //Crystals
    ItemStack pulsCry = new ItemStack(EnderIO.itemMaterial, 1, Material.PULSATING_CYSTAL.ordinal());
    GameRegistry.addShapedRecipe(pulsCry, "nnn", "ngn", "nnn", 'n', phasedIronNugget, 'g', Items.diamond);

    ItemStack vibCry = new ItemStack(EnderIO.itemMaterial, 1, Material.VIBRANT_CYSTAL.ordinal());
    GameRegistry.addShapedRecipe(vibCry, "nnn", "ngn", "nnn", 'n', vibrantNugget, 'g', Items.emerald);

    //Balls
    ItemStack darkBall = new ItemStack(EnderIO.itemMaterial, 5, Material.DARK_GRINDING_BALL.ordinal());
    GameRegistry.addShapedRecipe(darkBall, " s ", "sss", " s ", 's', darkSteel);

    //Smelting
    ItemStack dustIron = new ItemStack(EnderIO.itemPowderIngot, 1, PowderIngot.POWDER_IRON.ordinal());
    ItemStack dustGold = new ItemStack(EnderIO.itemPowderIngot, 1, PowderIngot.POWDER_GOLD.ordinal());
    ItemStack ingotIron = new ItemStack(Items.iron_ingot);
    ItemStack ingotGold = new ItemStack(Items.gold_ingot);

    GameRegistry.addSmelting(dustIron, ingotIron, 0);
    GameRegistry.addSmelting(dustGold, ingotGold, 0);

    //Ender Dusts
    ItemStack enderDust = new ItemStack(EnderIO.itemPowderIngot, 1, PowderIngot.POWDER_ENDER.ordinal());
    GameRegistry.addShapedRecipe(new ItemStack(Items.ender_pearl), "eee", "eee", "eee", 'e', enderDust);

    //Dark Iron Bars
    ItemStack diBars = new ItemStack(EnderIO.blockDarkIronBars, 16, 0);
    GameRegistry.addShapedRecipe(diBars, "ddd", "ddd", 'd', darkSteel);

    // Fused Quartz Frame
    GameRegistry.addRecipe(new ShapedOreRecipe(fusedQuartzFrame, "bsb", "s s", "bsb", 'b', conduitBinder, 's', "stickWood"));
    GameRegistry.addRecipe(new ShapedOreRecipe(fusedQuartzFrame, "bsb", "s s", "bsb", 'b', conduitBinder, 's', "woodStick"));

    // Machine Chassi

    ArrayList<ItemStack> steelIngots = OreDictionary.getOres("ingotSteel");

    if (Config.useSteelInChassi == true && steelIngots != null && !steelIngots.isEmpty()) {
      GameRegistry.addRecipe(new ShapedOreRecipe(machineChassi, "fif", "ici", "fif", 'f', Blocks.iron_bars, 'i', "ingotSteel", 'c', capacitor));
    } else {
      GameRegistry.addShapedRecipe(machineChassi, "fif", "ici", "fif", 'f', Blocks.iron_bars, 'i', Items.iron_ingot, 'c', capacitor);
    }

    // Basic Gear
    GameRegistry.addRecipe(new ShapedOreRecipe(basicGear, "scs", "c c", "scs", 's', "stickWood", 'c', Blocks.cobblestone));
    GameRegistry.addRecipe(new ShapedOreRecipe(basicGear, "scs", "c c", "scs", 's', "woodStick", 'c', Blocks.cobblestone));

    //Ender Capacitor
    ItemStack enderCapacitor = new ItemStack(EnderIO.itemBasicCapacitor, 1, 2);
    ItemStack activatedCapacitor = new ItemStack(EnderIO.itemBasicCapacitor, 1, 1);
    if (Config.useHardRecipes) {
      GameRegistry.addShapedRecipe(enderCapacitor, "eee", "cgc", "eee", 'e', phasedGold, 'c', activatedCapacitor, 'g', Blocks.glowstone);
    } else {
      GameRegistry.addShapedRecipe(enderCapacitor, " e ", "cgc", " e ", 'e', phasedGold, 'c', activatedCapacitor, 'g', Blocks.glowstone);
    }

    // Weather Crystal
    ItemStack main = Config.useHardRecipes ? new ItemStack(EnderIO.itemMaterial, 1, Material.VIBRANT_CYSTAL.ordinal()) : new ItemStack(Items.diamond);
    GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(EnderIO.itemMaterial, 1, Material.WEATHER_CRYSTAL.ordinal()), main, WeatherTask.CLEAR
        .requiredItem(), WeatherTask.RAIN.requiredItem(), WeatherTask.STORM.requiredItem()));

    if (Config.reinforcedObsidianEnabled) {
      ItemStack reinfObs = new ItemStack(EnderIO.blockReinforcedObsidian);
      ItemStack corners = darkSteel;
      if (Config.reinforcedObsidianUseDarkSteelBlocks) {
        corners = new ItemStack(EnderIO.blockIngotStorage, 1, Alloy.DARK_STEEL.ordinal());
      }
      GameRegistry.addShapedRecipe(reinfObs, "dbd", "bob", "dbd", 'd', corners, 'b', EnderIO.blockDarkIronBars, 'o', Blocks.obsidian);
    }

    GameRegistry.addRecipe(new ShapedOreRecipe(EnderIO.blockDarkSteelAnvil, "bbb", " i ", "iii",

    'b', "blockDarkSteel", 'i', "ingotDarkSteel"));

    GameRegistry.addRecipe(new ItemStack(EnderIO.blockDarkSteelLadder, 12), "b", "b", "b", 'b', EnderIO.blockDarkIronBars);

    for (Alloy alloy : Alloy.values()) {
      GameRegistry
          .addRecipe(new ShapedOreRecipe(new ItemStack(EnderIO.blockIngotStorage, 1, alloy.ordinal()), "iii", "iii", "iii", 'i', alloy.oredictIngotName));
      GameRegistry.addShapelessRecipe(new ItemStack(EnderIO.itemAlloy, 9, alloy.ordinal()), new ItemStack(EnderIO.blockIngotStorage, 1, alloy.ordinal()));
    }

    //Food
    ItemStack flour = new ItemStack(EnderIO.itemPowderIngot, 1, PowderIngot.FLOUR.ordinal());
    ItemStack bread = new ItemStack(Items.bread, 1, 0);

    GameRegistry.addSmelting(flour, bread, 0.35f);

  }

  public static void addOreDictionaryRecipes() {
    if (OreDictionaryHelper.hasCopper()) {
      ItemStack dustCopper = new ItemStack(EnderIO.itemPowderIngot, 1, PowderIngot.POWDER_COPPER.ordinal());
      ItemStack ingotCopper = OreDictionaryPreferences.instance.getPreferred(OreDictionaryHelper.INGOT_COPPER);
      GameRegistry.addSmelting(dustCopper, ingotCopper, 0);
    }
    if (hasTin()) {
      ItemStack dustTin = new ItemStack(EnderIO.itemPowderIngot, 1, PowderIngot.POWDER_TIN.ordinal());
      ItemStack ingotTin = OreDictionaryPreferences.instance.getPreferred(OreDictionaryHelper.INGOT_TIN);
      GameRegistry.addSmelting(dustTin, ingotTin, 0);
    }

    ItemStack capacitor = new ItemStack(EnderIO.itemBasicCapacitor, 1, 0);
    ArrayList<ItemStack> copperIngots = OreDictionary.getOres("ingotCopper");
    Item gold;
    if (Config.useHardRecipes) {
      gold = Items.gold_ingot;
    } else {
      gold = Items.gold_nugget;
    }
    if (copperIngots != null && !copperIngots.isEmpty() && Config.useModMetals) {
      GameRegistry.addRecipe(new ShapedOreRecipe(capacitor, " gr", "gcg", "rg ", 'r', Items.redstone, 'g', gold, 'c', "ingotCopper"));
    } else {
      GameRegistry.addShapedRecipe(capacitor, " gr", "gig", "rg ", 'r', Items.redstone, 'g', gold, 'i', Items.iron_ingot);
    }

    int dustCoal = OreDictionary.getOreID("dustCoal");
    ItemStack activatedCapacitor = new ItemStack(EnderIO.itemBasicCapacitor, 1, 1);
    ItemStack energeticAlloy = new ItemStack(EnderIO.itemAlloy, 1, Alloy.ENERGETIC_ALLOY.ordinal());
    if (Config.useHardRecipes) {
      GameRegistry.addRecipe(new ShapedOreRecipe(activatedCapacitor, "eee", "cCc", "eee", 'e', energeticAlloy, 'c', capacitor, 'C', "dustCoal"));
    } else {
      GameRegistry.addRecipe(new ShapedOreRecipe(activatedCapacitor, " e ", "cCc", " e ", 'e', energeticAlloy, 'c', capacitor, 'C', "dustCoal"));
    }
  }
}