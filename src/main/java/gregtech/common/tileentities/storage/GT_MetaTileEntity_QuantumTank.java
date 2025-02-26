package gregtech.common.tileentities.storage;

import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.util.GT_Utility;
import net.minecraft.util.EnumChatFormatting;

public class GT_MetaTileEntity_QuantumTank extends GT_MetaTileEntity_DigitalTankBase {
    public GT_MetaTileEntity_QuantumTank(int aID, String aName, String aNameRegional, int aTier) {
        super(aID, aName, aNameRegional, aTier);
    }

    public GT_MetaTileEntity_QuantumTank(String aName, int aTier, String aDescription, ITexture[][][] aTextures) {
        super(aName, aTier, aDescription, aTextures);
    }

    public GT_MetaTileEntity_QuantumTank(String aName, int aTier, String[] aDescription, ITexture[][][] aTextures) {
        super(aName, aTier, aDescription, aTextures);
    }

    @Override
    public MetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new GT_MetaTileEntity_QuantumTank(mName, mTier, mDescriptionArray, mTextures);
    }

    @Override
    public String[] getInfoData() {

        if (mFluid == null) {
            return new String[] {
                EnumChatFormatting.BLUE + "Quantum Tank" + EnumChatFormatting.RESET,
                "Current Capacity:",
                EnumChatFormatting.YELLOW + GT_Utility.formatNumbers(getCapacity()) + " L" + EnumChatFormatting.RESET,
                "Fluid Name:",
                EnumChatFormatting.GOLD + "No Fluid" + EnumChatFormatting.RESET,
                "Current Used:",
                EnumChatFormatting.GREEN + Integer.toString(0) + " L" + EnumChatFormatting.RESET
            };
        }
        return new String[] {
            EnumChatFormatting.BLUE + "Quantum Tank" + EnumChatFormatting.RESET,
            "Current Capacity:",
            EnumChatFormatting.YELLOW + GT_Utility.formatNumbers(getCapacity()) + " L" + EnumChatFormatting.RESET,
            "Fluid Name:",
            EnumChatFormatting.GOLD + mFluid.getLocalizedName() + EnumChatFormatting.RESET,
            "Current Used:",
            EnumChatFormatting.GREEN + GT_Utility.formatNumbers(mFluid.amount) + " L" + EnumChatFormatting.RESET
        };
    }
}
