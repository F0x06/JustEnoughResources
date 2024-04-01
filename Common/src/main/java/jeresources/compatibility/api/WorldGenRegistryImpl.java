package jeresources.compatibility.api;

import jeresources.api.IWorldGenRegistry;
import jeresources.api.distributions.DistributionBase;
import jeresources.api.drop.LootDrop;
import jeresources.api.restrictions.Restriction;
import jeresources.entry.WorldGenEntry;
import jeresources.registry.WorldGenRegistry;
import jeresources.util.LogHelper;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

public class WorldGenRegistryImpl implements IWorldGenRegistry {
    private static List<WorldGenEntry> registers = new LinkedList<>();
    private static List<Tuple<ItemStack, LootDrop[]>> addedDrops = new LinkedList<>();

    protected WorldGenRegistryImpl() {

    }

    @Override
    public void register(@NotNull ItemStack block, DistributionBase distribution, LootDrop... drops) {
        try {
            registers.add(new WorldGenEntry(block, distribution, drops));
        } catch (Exception e) {
            LogHelper.info("Error during worldgen registry for %s", block.toString());
        }
    }

    @Override
    public void register(@NotNull ItemStack block, @NotNull ItemStack deepSlateBlock, DistributionBase distribution, LootDrop... drops) {
        try {
            registers.add(new WorldGenEntry(block, deepSlateBlock, distribution, drops));
        } catch (Exception e) {
            LogHelper.info("Error during worldgen registry for %s", block.toString());
        }
    }

    @Override
    public void register(@NotNull ItemStack block, DistributionBase distribution, Restriction restriction, LootDrop... drops) {
        try {
            registers.add(new WorldGenEntry(block, distribution, restriction, drops));
        } catch (Exception e) {
            LogHelper.info("Error during worldgen registry for %s", block.toString());
        }
    }

    @Override
    public void register(@NotNull ItemStack block, @NotNull ItemStack deepSlateBlock, DistributionBase distribution, Restriction restriction, LootDrop... drops) {
        try {
            registers.add(new WorldGenEntry(block, deepSlateBlock, distribution, restriction, drops));
        } catch (Exception e) {
            LogHelper.info("Error during worldgen registry for %s", block.toString());
        }
    }

    @Override
    public void register(@NotNull ItemStack block, DistributionBase distribution, boolean silktouch, LootDrop... drops) {
        try {
            registers.add(new WorldGenEntry(block, distribution, silktouch, drops));
        } catch (Exception e) {
            LogHelper.info("Error during worldgen registry for %s", block.toString());
        }
    }

    @Override
    public void register(@NotNull ItemStack block, @NotNull ItemStack deepSlateBlock, DistributionBase distribution, boolean silktouch, LootDrop... drops) {
        try {
            registers.add(new WorldGenEntry(block, distribution, silktouch, drops));
        } catch (Exception e) {
            LogHelper.info("Error during worldgen registry for %s", block.toString());
        }
    }
    @Override
    public void register(@NotNull ItemStack block, DistributionBase distribution, Restriction restriction, boolean silktouch, LootDrop... drops) {
        try {
            registers.add(new WorldGenEntry(block, distribution, restriction, silktouch, drops));
        } catch (Exception e) {
            LogHelper.info("Error during worldgen registry for %s", block.toString());
        }
    }

    @Override
    public void register(@NotNull ItemStack block, @NotNull ItemStack deepSlateBlock, DistributionBase distribution, Restriction restriction, boolean silktouch, LootDrop... drops) {
        try {
            registers.add(new WorldGenEntry(block, deepSlateBlock, distribution, restriction, silktouch, drops));
        } catch (Exception e) {
            LogHelper.info("Error during worldgen registry for %s", block.toString());
        }
    }

    @Override
    public void registerDrops(@NotNull ItemStack block, LootDrop... drops) {
        if (drops.length > 0) addedDrops.add(new Tuple<>(block, drops));
    }

    protected static void commit() {
        for (WorldGenEntry entry : registers)
            WorldGenRegistry.getInstance().registerEntry(entry);
        for (Tuple<ItemStack, LootDrop[]> tuple : addedDrops)
            WorldGenRegistry.getInstance().addDrops(tuple.getA(), tuple.getB());
    }
}
