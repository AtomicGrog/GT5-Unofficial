package gregtech.common.covers;

import gregtech.api.GregTech_API;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.covers.IControlsWorkCover;
import gregtech.api.interfaces.tileentity.ICoverable;
import gregtech.api.util.ISerializableObject;
import net.minecraft.item.ItemStack;

public class GT_Cover_RedstoneTransmitterExternal extends GT_Cover_RedstoneWirelessBase {

    /**
     * @deprecated use {@link #GT_Cover_RedstoneTransmitterExternal(ITexture coverTexture)} instead
     */
    @Deprecated
    public GT_Cover_RedstoneTransmitterExternal() {
        this(null);
    }

    public GT_Cover_RedstoneTransmitterExternal(ITexture coverTexture) {
        super(coverTexture);
    }

    @Override
    public int doCoverThings(
            byte aSide, byte aInputRedstone, int aCoverID, int aCoverVariable, ICoverable aTileEntity, long aTimer) {
        // TODO remove next line after 2.3.0
        if (!IControlsWorkCover.makeSureOnlyOne(aSide, aTileEntity)) return aCoverVariable;
        GregTech_API.sWirelessRedstone.put(aCoverVariable, aInputRedstone);
        return aCoverVariable;
    }

    @Override
    protected boolean isRedstoneSensitiveImpl(
            byte aSide,
            int aCoverID,
            ISerializableObject.LegacyCoverData aCoverVariable,
            ICoverable aTileEntity,
            long aTimer) {
        return true;
    }

    @Override
    public boolean letsRedstoneGoIn(byte aSide, int aCoverID, int aCoverVariable, ICoverable aTileEntity) {
        return true;
    }

    @Override
    public int getTickRate(byte aSide, int aCoverID, int aCoverVariable, ICoverable aTileEntity) {
        return 1;
    }

    @Override
    public boolean isCoverPlaceable(byte aSide, ItemStack aStack, ICoverable aTileEntity) {
        if (!super.isCoverPlaceable(aSide, aStack, aTileEntity)) return false;
        for (byte i = 0; i < 6; i++) {
            if (aTileEntity.getCoverBehaviorAtSideNew(i) instanceof IControlsWorkCover) {
                return false;
            }
        }
        return true;
    }
}
