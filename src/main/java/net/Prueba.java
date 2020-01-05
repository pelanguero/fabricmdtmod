package net;
import net.blocks.IronFurnaceBlock;
import net.blocksEntity.IronFurnaceBlockEntity;
import  net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
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
    @Override
    public void onInitialize() {
       IRON_FURNACE= Registry.register(Registry.BLOCK_ENTITY,"prueba:iron_furnace_entity",BlockEntityType.Builder.create(IronFurnaceBlockEntity::new, IRON_FURNACE_BLOCK).build(null));
       Registry.register(Registry.BLOCK,new Identifier("prueba","iron_furnace_block"),IRON_FURNACE_BLOCK);
       Registry.register(Registry.ITEM,new Identifier("prueba","iron_furnace_item"), new BlockItem(IRON_FURNACE_BLOCK,new Item.Settings().group(ItemGroup.MISC)));
       Registry.BIOME.forEach(this::handleBiome);

    }

    private void handleBiome(Biome bioma) {
        if (bioma.getCategory() == Biome.Category.NETHER || bioma.getCategory() == Biome.Category.THEEND) {
            bioma.addFeature(
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    Biome.configureFeature(
                            Feature.ORE,
                            new OreFeatureConfig(
                                    OreFeatureConfig.Target.NETHERRACK,
                                    Blocks.DIAMOND_ORE.getDefaultState(),
                                    8 //Ore vein size
                            ),
                            Decorator.COUNT_RANGE,
                            new RangeDecoratorConfig(
                                    40, //Number of veins per chunk
                                    0, //Bottom Offset
                                    0, //Min y level
                                    128 //Max y level
                            )));
        }
    }
}

