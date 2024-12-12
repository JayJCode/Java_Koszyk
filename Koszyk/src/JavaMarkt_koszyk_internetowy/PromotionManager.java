package JavaMarkt_koszyk_internetowy;

import java.util.ArrayList;
import java.util.List;

public class PromotionManager {
    private List<PromotionCommand> promotions;

    public PromotionManager() {
        this.promotions = new ArrayList<>();
    }

    public void addPromotion(PromotionCommand promotion) {
        promotions.add(promotion);
    }

    public void removePromotion(PromotionCommand promotion) {
        promotions.remove(promotion);
    }

    public void removePromotionByClass(Class<?> promotionClass) {
        promotions.removeIf(promotion -> promotion.getClass().equals(promotionClass));
    }

    public void applyPromotions(ShoppingCart shoppingCart) {
        for (PromotionCommand promotion : promotions) {
            promotion.apply(shoppingCart);
        }
    }

    public List<PromotionCommand> getPromotions() {
        return new ArrayList<>(promotions);
    }

    public void setDefaultPromotions() {
        DiscountOnTotalPromotion fivePercentDiscount = new DiscountOnTotalPromotion(300, 0.05);
        FreeProductPromotion thirdProductFree = new FreeProductPromotion(3);
        FreeGiftPromotion freeCup = new FreeGiftPromotion(200, "999", "Firmowy kubek");
        VoucherOnProduct voucher = new VoucherOnProduct("333", 0.30);
        addPromotion(fivePercentDiscount);
        addPromotion(thirdProductFree);
        addPromotion(freeCup);
        addPromotion(voucher);
    }
}
