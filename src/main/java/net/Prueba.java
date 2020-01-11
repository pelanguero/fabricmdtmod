package net;
import net.blocks.IronFurnaceBlock;
import net.blocks.MdtOreBlock;
import net.blocksEntity.IronFurnaceBlockEntity;
import  net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;


public class Prueba implements ModInitializer {
    public static BlockEntityType<IronFurnaceBlockEntity> IRON_FURNACE;
    //Block.Settings furnaceLikeProperties = Block.Settings.copy(Blocks.FURNACE);
    public static Block IRON_FURNACE_BLOCK=new IronFurnaceBlock(Block.Settings.copy(Blocks.FURNACE));
    public static OreBlock IRON_NETHER =new OreBlock(Block.Settings.copy(Blocks.IRON_ORE));
    public static OreBlock DIAMOND_NETHER=new OreBlock(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).strength(2,0.6f).build());
    public static OreBlock EMERALD_NETHER=new OreBlock(Block.Settings.copy(Blocks.EMERALD_ORE));
    public static OreBlock LAPIS_NETHER=new OreBlock(Block.Settings.copy(Blocks.LAPIS_ORE));
    public static OreBlock REDSTONE_NETHER=new OreBlock(Block.Settings.copy(Blocks.REDSTONE_ORE));
    public static OreBlock ORO_NETHER=new OreBlock(Block.Settings.copy(Blocks.GOLD_ORE));
    @Override
    public void onInitialize() {
       IRON_FURNACE= Registry.register(Registry.BLOCK_ENTITY,"prueba:iron_furnace_entity",BlockEntityType.Builder.create(IronFurnaceBlockEntity::new, IRON_FURNACE_BLOCK).build(null));
       Registry.register(Registry.BLOCK,new Identifier("prueba","iron_furnace"),IRON_FURNACE_BLOCK);
       Registry.register(Registry.BLOCK,new Identifier("prueba","iron_nether"),IRON_NETHER);
       Registry.register(Registry.BLOCK,new Identifier("prueba", "diamond_nether"),DIAMOND_NETHER);
       Registry.register(Registry.BLOCK,new Identifier("prueba", "emerald_nether"),EMERALD_NETHER);
       Registry.register(Registry.BLOCK,new Identifier("prueba", "lapis_nether"),LAPIS_NETHER);
       Registry.register(Registry.BLOCK,new Identifier("prueba", "redstone_nether"),REDSTONE_NETHER);
       Registry.register(Registry.BLOCK,new Identifier("prueba", "oro_nether"),ORO_NETHER);
       Registry.register(Registry.ITEM,new Identifier("prueba","iron_nether_item"), new BlockItem(IRON_NETHER,new Item.Settings().group(ItemGroup.MISC)));
       Registry.register(Registry.ITEM,new Identifier("prueba","diamond_nether_item"), new BlockItem(DIAMOND_NETHER,new Item.Settings().group(ItemGroup.MISC)));
       Registry.register(Registry.ITEM,new Identifier("prueba","emerald_nether_item"), new BlockItem(EMERALD_NETHER,new Item.Settings().group(ItemGroup.MISC)));
       Registry.register(Registry.ITEM,new Identifier("prueba","lapis_nether_item"), new BlockItem(LAPIS_NETHER,new Item.Settings().group(ItemGroup.MISC)));
       Registry.register(Registry.ITEM,new Identifier("prueba","redstone_nether_item"), new BlockItem(REDSTONE_NETHER,new Item.Settings().group(ItemGroup.MISC)));
       Registry.register(Registry.ITEM,new Identifier("prueba","oro_nether_item"), new BlockItem(ORO_NETHER,new Item.Settings().group(ItemGroup.MISC)));
       Registry.register(Registry.ITEM,new Identifier("prueba","iron_furnace_item"), new BlockItem(IRON_FURNACE_BLOCK,new Item.Settings().group(ItemGroup.MISC)));

       Registry.BIOME.forEach(this::handleBiome);
    }

    private void handleBiome(Biome bioma) {
        if (bioma.getCategory() == Biome.Category.NETHER) {
            bioma.addFeature(
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    Biome.configureFeature(
                            Feature.ORE,
                            new OreFeatureConfig(
                                    OreFeatureConfig.Target.NETHERRACK,
                                    DIAMOND_NETHER.getDefaultState(),
                                    8 //Ore vein size
                            ),
                            Decorator.COUNT_RANGE,
                            new RangeDecoratorConfig(
                                    8, //Number of veins per chunk
                                    0, //Bottom Offset
                                    0, //Min y level
                                    60 //Max y level
                            )));
            bioma.addFeature(
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    Biome.configureFeature(
                            Feature.ORE,
                            new OreFeatureConfig(
                                    OreFeatureConfig.Target.NETHERRACK,
                                    IRON_NETHER.getDefaultState(),
                                    8 //Ore vein size
                            ),
                            Decorator.COUNT_RANGE,
                            new RangeDecoratorConfig(
                                    64, //Number of veins per chunk
                                    0, //Bottom Offset
                                    0, //Min y level
                                    100 //Max y level
                            )));
            bioma.addFeature(
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    Biome.configureFeature(
                            Feature.ORE,
                            new OreFeatureConfig(
                                    OreFeatureConfig.Target.NETHERRACK,
                                    LAPIS_NETHER.getDefaultState(),
                                    8 //Ore vein size
                            ),
                            Decorator.COUNT_RANGE,
                            new RangeDecoratorConfig(
                                    24, //Number of veins per chunk
                                    0, //Bottom Offset
                                    0, //Min y level
                                    80 //Max y level
                            )));
            bioma.addFeature(
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    Biome.configureFeature(
                            Feature.ORE,
                            new OreFeatureConfig(
                                    OreFeatureConfig.Target.NETHERRACK,
                                    EMERALD_NETHER.getDefaultState(),
                                    8 //Ore vein size
                            ),
                            Decorator.COUNT_RANGE,
                            new RangeDecoratorConfig(
                                    8, //Number of veins per chunk
                                    0, //Bottom Offset
                                    0, //Min y level
                                    60 //Max y level
                            )));
            bioma.addFeature(
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    Biome.configureFeature(
                            Feature.ORE,
                            new OreFeatureConfig(
                                    OreFeatureConfig.Target.NETHERRACK,
                                    REDSTONE_NETHER.getDefaultState(),
                                    8 //Ore vein size
                            ),
                            Decorator.COUNT_RANGE,
                            new RangeDecoratorConfig(
                                    30, //Number of veins per chunk
                                    0, //Bottom Offset
                                    0, //Min y level
                                    80 //Max y level
                            )));
            bioma.addFeature(
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    Biome.configureFeature(
                            Feature.ORE,
                            new OreFeatureConfig(
                                    OreFeatureConfig.Target.NETHERRACK,
                                    ORO_NETHER.getDefaultState(),
                                    8 //Ore vein size
                            ),
                            Decorator.COUNT_RANGE,
                            new RangeDecoratorConfig(
                                    30, //Number of veins per chunk
                                    0, //Bottom Offset
                                    0, //Min y level
                                    80 //Max y level
                            )));

        }
    }
}

