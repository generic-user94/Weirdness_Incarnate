package net.generic_user94.weirdnessincarnate.block;

import net.generic_user94.weirdnessincarnate.WeirdnessIncarnate;
import net.generic_user94.weirdnessincarnate.block.custom.AnuliteLampBlock;
import net.generic_user94.weirdnessincarnate.block.custom.MagicBlock;
import net.generic_user94.weirdnessincarnate.block.custom.MagicBlockTwo;
import net.generic_user94.weirdnessincarnate.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(WeirdnessIncarnate.MOD_ID);


    public static final DeferredBlock<Block> ANULITE_BLOCK = registerBlock("anulite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> ANULITE_ORE = registerBlock("anulite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_ORE)));

    public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .sound(SoundType.NETHER_ORE)));
    public static final DeferredBlock<Block> MAGIC_BLOCK_TWO = registerBlock("magic_block_two",
            () -> new MagicBlockTwo(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .sound(SoundType.NETHER_ORE)));

    public static final DeferredBlock<StairBlock> ANULITE_STAIR = registerBlock("anulite_stair",
            () -> new StairBlock(ModBlocks.ANULITE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .requiresCorrectToolForDrops()));
    public static final DeferredBlock<SlabBlock> ANULITE_SLAB = registerBlock("anulite_slab",
            () -> new SlabBlock(
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .requiresCorrectToolForDrops()));

    public static final DeferredBlock<PressurePlateBlock> ANULITE_PRESSURE_PLATE = registerBlock("anulite_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .requiresCorrectToolForDrops()));
    public static final DeferredBlock<ButtonBlock> ANULITE_BUTTON = registerBlock("anulite_button",
            () -> new ButtonBlock(BlockSetType.IRON, 20,
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .requiresCorrectToolForDrops()
                            .noCollission()));

    public static final DeferredBlock<FenceBlock> ANULITE_FENCE = registerBlock("anulite_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of()
                            .strength(2f)
                            .requiresCorrectToolForDrops()));
    public static final DeferredBlock<FenceGateBlock> ANULITE_FENCE_GATE = registerBlock("anulite_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.of()
                            .strength(2f)
                            .requiresCorrectToolForDrops()));
    public static final DeferredBlock<WallBlock> ANULITE_WALL = registerBlock("anulite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                            .strength(2f)
                            .requiresCorrectToolForDrops()));

    public static final DeferredBlock<DoorBlock> ANULITE_DOOR = registerBlock("anulite_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of()
                            .strength(2f)
                            .requiresCorrectToolForDrops()
                            .noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> ANULITE_TRAPDOOR = registerBlock("anulite_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .requiresCorrectToolForDrops()
                            .noOcclusion()));

    public static final DeferredBlock<Block> ANULITE_LAMP = registerBlock("anulite_lamp",
            () -> new AnuliteLampBlock(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(AnuliteLampBlock.CLICKED) ? 15 : 0)));









    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
